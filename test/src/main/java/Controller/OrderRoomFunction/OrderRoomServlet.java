package Controller.OrderRoomFunction;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberOrder.MemberOrderBean;
import model.MemberOrder.MemberOrderService;
import model.OrderRoomInfo.OrderRoomInfoBean;
import model.OrderRoomInfo.OrderRoomInfoService;
import model.RoomInfo.RoomInfoBean;
import model.RoomInfo.RoomInfoService;

@WebServlet("/OrderRoomServlet")
public class OrderRoomServlet extends HttpServlet {
	
	private MemberOrderService memberOrderService=new MemberOrderService();
	private OrderRoomInfoService orderRoomInfoService= new OrderRoomInfoService();
	private RoomInfoService roomInfoService= new RoomInfoService();	
	private Date today =new Date();
	private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 接收資料
		String memberID_str = request.getParameter("memberID");
//		String memberDate = request.getParameter("memberDate");
//		String roomTotalSum_str = request.getParameter("roomTotalSum");
//		String memberSum_str = request.getParameter("memberSum");
//		String haveDelete_str = request.getParameter("haveDelete");
		String inDate_str = request.getParameter("inDate");
		String outDate_str = request.getParameter("outDate");
//		String orderID_str = request.getParameter("orderID");
//		String roomSum_str = request.getParameter("roomSum");
		String roomCode_str = request.getParameter("roomCode");
		String submit = request.getParameter("submit");
						
		//轉換資料
		Map<String,String> errors=new HashMap<String,String>();//存放錯誤訊息
		request.setAttribute("error",errors);//設定錯誤訊息的被el取值名稱
		int memberID=0;
		memberID = Integer.parseInt(memberID_str);
		int roomCode=0;
		roomCode = Integer.parseInt(roomCode_str);
		Date inDate = null;
		Date outDate = null;
		try {
			inDate=dateFormat.parse(inDate_str);
			outDate=dateFormat.parse(outDate_str);
		}
		catch (ParseException e) {
			e.printStackTrace();
			System.out.println("日期的轉型錯誤");
		}
			
			
		//驗證資料	
			
			
			
			
		//呼叫Model, 根據Model執行結果顯示View
		
		//設insert進資料庫的MemberOrderBean
		MemberOrderBean memberOrderBean = new MemberOrderBean();
		memberOrderBean.setMemberID(memberID);
		memberOrderBean.setMemberDate(today);
		memberOrderBean.setHaveDelete(false);						
				
		if("submit".equals(submit)) {
			//insert_MemberOrder
			boolean memberOrder_result = memberOrderService.insert(memberOrderBean);
			//利用meberID和今天日期取得orderID
			int orderID = 0;
			List<MemberOrderBean> orderBean = memberOrderService.selecTByDateRange(memberID,today,today);
			if(!orderBean.isEmpty()){
				MemberOrderBean bean=orderBean.get(0);
				orderID = bean.getOrderID();
			}else
				System.out.println("搜尋訂單錯誤_資料為空");

			
			//設insert進資料庫的OrderRoomInfoBean
			OrderRoomInfoBean orderRoomInfoBean=new OrderRoomInfoBean();
			orderRoomInfoBean.setOrderID(orderID);
			orderRoomInfoBean.setRoomCode(roomCode);
			orderRoomInfoBean.setInDate(inDate);
			orderRoomInfoBean.setOutDate(outDate);
			//取得roomPrice
			RoomInfoBean roomInfoBean= roomInfoService.selectByRoomCode(roomCode);
			double roomPrice = roomInfoBean.getRoomPrice();
			//設roomSum進orderRoomInfoBean
			orderRoomInfoBean.setRoomSum(roomPrice);	
			//insert_orderRoomInfo			
			boolean orderRoomInfo_result=orderRoomInfoService.insert(orderRoomInfoBean);
			//利用orderID搜尋roomSum後加總起來再塞給memberOrder
			List<OrderRoomInfoBean> orderRoomInfoBeans=orderRoomInfoService.selectByOrderID(orderID);
			double roomTotalSum=0;
			for(OrderRoomInfoBean infoBean:orderRoomInfoBeans){
				double roomsum=infoBean.getRoomSum();
				roomTotalSum=roomTotalSum+roomsum;
			}			
			//更新memberOrder
			memberOrderBean.setRoomTotalSum(roomTotalSum);
			memberOrderBean.setMemberSum(roomTotalSum);
			boolean memberOrder_update_result=memberOrderService.update(memberOrderBean);
			
			if(memberOrder_result==true && orderRoomInfo_result==true && memberOrder_update_result==true) {
				request.setAttribute("insertResult", "訂房成功");				
			}else {
				errors.put("insertResult", "訂房失敗");
			}
			request.getRequestDispatcher("/Order/OrderRoom.jsp").forward(request, response);
		} 
			
			
			
				

	}

}
