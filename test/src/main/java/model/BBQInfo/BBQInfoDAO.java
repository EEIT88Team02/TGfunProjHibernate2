package model.BBQInfo;

import java.util.List;

import org.hibernate.Session;

import misc.HibernateUtil;
import model.MemberOrder.MemberOrderBean;

public class BBQInfoDAO implements BBQInfoInterface {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
			BBQInfoDAO dao = new BBQInfoDAO(session);
			BBQInfoBean result=dao.selectByBBQID(1);
			
			System.out.println(result);


			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}
	
	private Session session = null;

	public BBQInfoDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BBQInfoBean selectByBBQID(int bbqID) {
		String select_by_bbqID = 
				"FROM BBQInfoBean WHERE bbqID =:bbqID";
		BBQInfoBean result =(BBQInfoBean) this.getSession()
							.createQuery(select_by_bbqID)
							.setInteger("bbqID",bbqID)
							.uniqueResult();
		return result;
	}


}
