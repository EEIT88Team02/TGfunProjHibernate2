package model.OrderRoomInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;

import model.MemberOrder.MemberOrderBean;
import model.misc.HibernateUtil;

public class OrderRoomInfoDAO implements OrderRoomInfoInterface{

	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
//			OrderRoomInfoDAO dao = new OrderRoomInfoDAO(session);
//			List<OrderRoomInfoBean> result=dao.selectByOrderID(2);
//			for(OrderRoomInfoBean bean:result){
//					System.out.println(bean);
//			}			
			
//			OrderRoomInfoDAO dao = new OrderRoomInfoDAO(session);
//			OrderRoomInfoBean orderRoomInfoBean=new OrderRoomInfoBean();
//			orderRoomInfoBean.setOrderID(2);
//			orderRoomInfoBean.setRoomCode(101);
//			orderRoomInfoBean.setRoomSum(25000);
//			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");			 
//			orderRoomInfoBean.setInDate(dateFormat.parse("2016-10-14"));
//			orderRoomInfoBean.setOutDate(dateFormat.parse("2016-11-15"));
//			dao.insert(orderRoomInfoBean);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}
	
	private Session session = null;

	public OrderRoomInfoDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderRoomInfoBean> selectByOrderID(int orderID) {
		String select_by_orderID = 
				"FROM OrderRoomInfoBean WHERE orderID =:orderID ORDER BY inDate DESC, outDate";
		List<OrderRoomInfoBean> result =this.getSession()
							.createQuery(select_by_orderID)
							.setInteger("orderID",orderID)
							.list();
		return result;
	}

	@Override
	public boolean insert(OrderRoomInfoBean orderRoomInfoBean) {

		try {
			this.getSession().save(orderRoomInfoBean);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
