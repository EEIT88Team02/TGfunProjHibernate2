package model.OrderRoomInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;

import model.MemberOrder.MemberOrderDAO;
import model.misc.HibernateUtil;

public class OrderRoomInfoService {

	private OrderRoomInfoDAO orderRoomInfoDAO;

	public OrderRoomInfoService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		orderRoomInfoDAO = new OrderRoomInfoDAO(session);
	}
	
	public List<OrderRoomInfoBean> selectByOrderID(int orderID) {
		return orderRoomInfoDAO.selectByOrderID(orderID);	
	}
	public boolean insert(OrderRoomInfoBean orderRoomInfoBean) {
		boolean result=orderRoomInfoDAO.insert(orderRoomInfoBean);
		if(result==true)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

//			OrderRoomInfoService service= new OrderRoomInfoService();
//			List<OrderRoomInfoBean> result=service.selectByOrderID(1);
//			for(OrderRoomInfoBean bean:result){
//					System.out.println(bean);
//			}
			
//			OrderRoomInfoService service = new OrderRoomInfoService();
//			OrderRoomInfoBean orderRoomInfoBean=new OrderRoomInfoBean();
//			orderRoomInfoBean.setOrderID(2);
//			orderRoomInfoBean.setRoomCode(102);
//			orderRoomInfoBean.setRoomSum(25000);
//			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");			 
//			orderRoomInfoBean.setInDate(dateFormat.parse("2016-10-14"));
//			orderRoomInfoBean.setOutDate(dateFormat.parse("2016-11-15"));
//			service.insert(orderRoomInfoBean);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
