package model.BBQInfo;

import org.hibernate.Session;

import misc.HibernateUtil;
import model.MemberOrder.MemberOrderDAO;

public class BBQInfoService {
	
	private BBQInfoDAO bbqInfoDAO;

	public BBQInfoService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		bbqInfoDAO = new BBQInfoDAO(session);
	}
	
	public BBQInfoBean selectByBBQID(int bbqID) {
		return bbqInfoDAO.selectByBBQID(bbqID);
		
	}
	
	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
			BBQInfoService service = new BBQInfoService();
			BBQInfoBean result=service.selectByBBQID(1);
			
			System.out.println(result);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
