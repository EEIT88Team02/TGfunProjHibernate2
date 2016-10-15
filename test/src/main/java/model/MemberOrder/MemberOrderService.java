package model.MemberOrder;

import org.hibernate.Session;

import model.misc.HibernateUtil;

public class MemberOrderService {

	private MemberOrderDAO memberOrderDAO;

	public MemberOrderService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		memberOrderDAO = new MemberOrderDAO(session);
	}
	
	

	public static void main(String[] args) {

	}

}
