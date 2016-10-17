package Controller.OrderRoomFunction;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderRoomServlet")
public class OrderRoomServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		String memberID_str = request.getParameter("memberID");
//		String memberDate = request.getParameter("memberDate");
//		String roomTotalSum_str = request.getParameter("roomTotalSum");
//		String memberSum_str = request.getParameter("memberSum");
//		String haveDelete_str = request.getParameter("haveDelete");
		String inDate = request.getParameter("inDate");
		String outDate = request.getParameter("outDate");
		String orderID_str = request.getParameter("orderID");
//		String roomSum_str = request.getParameter("roomSum");
		
		
		//轉換資料
			Map<String,String> errors=new HashMap<String,String>();
			request.setAttribute("error",errors);
			int memberID=0;
			memberID = Integer.parseInt(memberID_str);
			
			

			
			
			
				

	}

}
