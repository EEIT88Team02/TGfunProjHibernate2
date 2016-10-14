package model.BBQOrder;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import model.MemberOrder.MemberOrderBean;
import model.OrderRoomInfo.OrderRoomInfoBean;
import model.misc.HibernateUtil;


public class BBQOrderDAO implements BBQOrderInterface {

	
	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
//			BBQOrderDAO dao = new BBQOrderDAO(session);
//			List<BBQOrderBean> result=dao.selectByOrderID(1);
//			for(BBQOrderBean bean:result){
//					System.out.println(bean);
//			}			
			
//			BBQOrderDAO dao = new BBQOrderDAO(session);
//			List<BBQOrderBean> result=dao.selectByHaveDelete(true);
//			for(BBQOrderBean bean:result){
//							System.out.println(bean);
//			}
			
//			BBQOrderDAO dao=new BBQOrderDAO(session);
//			BBQOrderBean bbqOrderBean=new BBQOrderBean();
//			bbqOrderBean.setOrderID(1);  
//			bbqOrderBean.setBbqID(3);     
//			bbqOrderBean.setBbqDate(new Date());
//			bbqOrderBean.setHaveDelete(false);
//			dao.insert(bbqOrderBean);
			
//			BBQOrderDAO dao=new BBQOrderDAO(session);
//			BBQOrderBean bbqOrderBean=new BBQOrderBean();
//			bbqOrderBean.setBbqOrderID(1);
//			bbqOrderBean.setOrderID(1);
//			bbqOrderBean.setBbqID(1);
//			bbqOrderBean.setBbqDate(new Date());
//			bbqOrderBean.setHaveDelete(true);
//			dao.update(bbqOrderBean);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	private Session session = null;

	public BBQOrderDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BBQOrderBean> selectByOrderID(int orderID) {
		String select_by_orderID = "FROM BBQOrderBean WHERE orderID =:orderID";
		List<BBQOrderBean> result =this.getSession()
									.createQuery(select_by_orderID)
									.setInteger("orderID",orderID)
									.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BBQOrderBean> selectByHaveDelete(boolean haveDelete) {
		String select_by_haveDelete = "FROM BBQOrderBean WHERE haveDelete = :haveDelete ORDER BY bbqDate DESC";
		List<BBQOrderBean> result =this.getSession()
										.createQuery(select_by_haveDelete)										
										.setBoolean("haveDelete",haveDelete)
										.list();
		return result;
	}

	@Override
	public BBQOrderBean insert(BBQOrderBean bbqOrderBean) {
		int id= bbqOrderBean.getBbqID();
		BBQOrderBean bean=session.get(BBQOrderBean.class,id);
		if(bean==null){
		this.getSession().save(bbqOrderBean);		
		return bean;
		}
		return null;
	}

	@Override
	public BBQOrderBean update(BBQOrderBean bbqOrderBean) {
		this.getSession().saveOrUpdate(bbqOrderBean);
		return bbqOrderBean;
	}

}
