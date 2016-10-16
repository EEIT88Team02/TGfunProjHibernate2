package model.MemberOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import model.BBQOrder.BBQOrderBean;
import model.BBQOrder.BBQOrderService;
import model.OrderRoomInfo.OrderRoomInfoBean;
import model.OrderRoomInfo.OrderRoomInfoService;
import model.misc.HibernateUtil;

public class MemberOrderService {

	private MemberOrderDAO memberOrderDAO;

	public MemberOrderService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		memberOrderDAO = new MemberOrderDAO(session);
	}

	public List<MemberOrderBean> selectByMemberID(int memberID,boolean haveDelete) {
		return memberOrderDAO.selectByMemberID(memberID,haveDelete);
	}
	
	public List<MemberOrderBean> selecTByDateRange(int memberID,String firstDate,String lastDate) {
		return memberOrderDAO.selecTByDateRange(memberID,firstDate,lastDate);
	}
	
	public boolean insert(MemberOrderBean memberOrderBean) {
		boolean result=memberOrderDAO.insert(memberOrderBean);
		if(result==true)
			return true;
		else
			return false;
	}
	
	public MemberOrderBean updateHaveDelete(MemberOrderBean memberOrderBean) {
		return memberOrderDAO.updateHaveDelete(memberOrderBean);
	}
	
	public boolean order(MemberOrderBean memberOrderBean ,OrderRoomInfoBean orderRoomInfoBean,BBQOrderBean bbqOrderBean) {
		try {
			this.insert(memberOrderBean);
			
			OrderRoomInfoService orderRoomInfoService = new OrderRoomInfoService();
			orderRoomInfoService.insert(orderRoomInfoBean);
			
			BBQOrderService bbqOrderService = new BBQOrderService();
			bbqOrderService.insert(bbqOrderBean);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}

	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

//			 MemberOrderService service= new MemberOrderService();
//			 List<MemberOrderBean> result=service.selectByMemberID(2,true);
//			 for(MemberOrderBean bean:result){
//			 System.out.println(bean);
//			 }

//			MemberOrderService service = new MemberOrderService();
//			List<MemberOrderBean> result=service.selecTByDateRange(1,"2016-10-12","2016-10-16");
//			for(MemberOrderBean bean:result){
//			System.out.println(bean);
//			}

//			MemberOrderService service = new MemberOrderService();
//			MemberOrderBean memberOrderBean=new MemberOrderBean();
//			memberOrderBean.setMemberID(1);
//			memberOrderBean.setMemberDate(new Date());
//			memberOrderBean.setMemberSum(150000);
//			service.insert(memberOrderBean);

//			MemberOrderService service = new MemberOrderService();
//			MemberOrderBean memberOrderBean=new MemberOrderBean();
//			memberOrderBean.setOrderID(2);
//			memberOrderBean.setMemberID(2);
//			memberOrderBean.setRoomTotalSum(10000);
//			memberOrderBean.setMemberSum(10000);
//			memberOrderBean.setMemberDate(new Date());
//			memberOrderBean.setHaveDelete(false);
//			service.update(memberOrderBean);

			
			
//			MemberOrderService service = new MemberOrderService();
//			
//			MemberOrderBean memberOrderBean=new MemberOrderBean();
//			memberOrderBean.setMemberID(1);
//			memberOrderBean.setMemberDate(new Date());
//			memberOrderBean.setMemberSum(150000);
//			
//			BBQOrderBean bbqOrderBean=new BBQOrderBean();
//			bbqOrderBean.setOrderID(1);  
//			bbqOrderBean.setBbqID(3);     
//			bbqOrderBean.setBbqDate(new Date());
//			bbqOrderBean.setHaveDelete(false);
//			
//			OrderRoomInfoBean orderRoomInfoBean=new OrderRoomInfoBean();
//			orderRoomInfoBean.setOrderID(2);
//			orderRoomInfoBean.setRoomCode(102);
//			orderRoomInfoBean.setRoomSum(25000);
//			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");			 
//			orderRoomInfoBean.setInDate(dateFormat.parse("2016-10-14"));
//			orderRoomInfoBean.setOutDate(dateFormat.parse("2016-11-15"));
//			
//			service.order(memberOrderBean,orderRoomInfoBean,bbqOrderBean);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
