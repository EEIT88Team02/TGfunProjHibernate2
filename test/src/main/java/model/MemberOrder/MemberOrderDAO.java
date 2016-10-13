package model.MemberOrder;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.misc.HibernateUtil;

public class MemberOrderDAO implements MemberOrderInterface {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			List<MemberOrderBean> result=dao.selectByMemberID(1);
//			System.out.println(result);
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			List<MemberOrderBean> result=dao.selectByHaveDelete(2,false);
//			System.out.println(result);
			
			

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	private Session session = null;

	public MemberOrderDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberOrderBean> selectByMemberID(int memberID) {
		String select_by_id = "from MemberOrderBean where memberID = :memberID";
		List<MemberOrderBean> result =this.getSession()
										.createQuery(select_by_id)
										.setInteger("memberID",memberID)
										.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberOrderBean> selectByHaveDelete(int memberID, boolean haveDelete) {
		String select_by_haveDelete = 
							"from MemberOrderBean where memberID =:memberID and haveDelete = :haveDelete";
		List<MemberOrderBean> result =this.getSession()
										.createQuery(select_by_haveDelete)
										.setInteger("memberID",memberID)
										.setBoolean("haveDelete",haveDelete)
										.list();
		return result;
	}

	@Override
	public List<MemberOrderBean> selecTByMemberDate(Date memberDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberOrderBean insert(MemberOrderBean memberOrderBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberOrderBean update(int orderID, int memberID, Date memberDate, double roomTotalSum, double memberSum, boolean haveDelete) {
		// TODO Auto-generated method stub
		return null;
	}

}
