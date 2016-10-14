package model.MemberOrder;

import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.misc.HibernateUtil;

public class MemberOrderDAO implements MemberOrderInterface {

	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			List<MemberOrderBean> result=dao.selectByMemberID(1);
//			for(MemberOrderBean bean:result){
//					System.out.println(bean);
//			}
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			List<MemberOrderBean> result=dao.selectByHaveDelete(1,false);
//						for(MemberOrderBean bean:result){
//			System.out.println(bean);
//	}
			
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			List<MemberOrderBean> result=dao.selecTByDateRange(1,"2016-10-12","2016-10-14");			
//			for(MemberOrderBean bean:result){
//				System.out.println(bean);
//			}
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			MemberOrderBean memberOrderBean=new MemberOrderBean();
//			memberOrderBean.setMemberID(1);
//			memberOrderBean.setMemberDate(new Date());
//			memberOrderBean.setMemberSum(150000);
//			dao.insert(memberOrderBean);
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			MemberOrderBean memberOrderBean=new MemberOrderBean();
//			memberOrderBean.setOrderID(2);
//			memberOrderBean.setMemberID(2);
//			memberOrderBean.setRoomTotalSum(10000);
//			memberOrderBean.setMemberSum(10000);
//			memberOrderBean.setMemberDate(new Date());
//			memberOrderBean.setHaveDelete(false);
//			dao.update(memberOrderBean);	

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
		String select_by_memberID = 
				"FROM MemberOrderBean WHERE memberID =:memberID ORDER BY memberDate DESC";
		List<MemberOrderBean> result =this.getSession()
							.createQuery(select_by_memberID)
							.setInteger("memberID",memberID)
							.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberOrderBean> selectByHaveDelete(int memberID, boolean haveDelete) {
		String select_by_haveDelete = 
							"FROM MemberOrderBean WHERE memberID =:memberID AND haveDelete = :haveDelete ORDER BY memberDate DESC";
		List<MemberOrderBean> result =this.getSession()
										.createQuery(select_by_haveDelete)
										.setInteger("memberID",memberID)
										.setBoolean("haveDelete",haveDelete)
										.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberOrderBean> selecTByDateRange(int memberID,String firstDate,String lastDate) {
		String select_by_dateRange = 
			"from MemberOrderBean m where m.memberID = :memberID AND m.memberDate between convert(datetime,(:firstDate +' 00:00:00')) AND CONVERT(datetime,(:lastDate + ' 23:59:59.997'))";
		List<MemberOrderBean> result =this.getSession()
									.createQuery(select_by_dateRange)
									.setInteger("memberID",memberID)
									.setString("firstDate",firstDate)
									.setString("lastDate",lastDate)
									.list();	
		return result;
	}

	@Override
	public MemberOrderBean insert(MemberOrderBean memberOrderBean) {
		int id= memberOrderBean.getOrderID();
		MemberOrderBean bean=session.get(MemberOrderBean.class,id);
		if(bean==null){
		this.getSession().save(memberOrderBean);		
		return bean;
		}
		return null;
	}

	@Override
	public MemberOrderBean update(MemberOrderBean memberOrderBean) {
			this.getSession().saveOrUpdate(memberOrderBean);
			return memberOrderBean;
	}

}