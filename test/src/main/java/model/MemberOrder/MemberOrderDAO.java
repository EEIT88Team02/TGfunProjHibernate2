package model.MemberOrder;


import java.text.ParseException;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.BBQOrder.BBQOrderBean;
import model.OrderRoomInfo.OrderRoomInfoBean;
import model.misc.HibernateUtil;

public class MemberOrderDAO implements MemberOrderInterface {

	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			List<MemberOrderBean> result=dao.selectByMemberID(1,false);		
//			for(MemberOrderBean bean:result){
//				System.out.println(bean);
//		}
									
			
//			MemberOrderDAO dao = new MemberOrderDAO(session);
//			List<MemberOrderBean> result=dao.selecTByDateRange(1,"2016-10-12","2016-10-16");			
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
	public List<MemberOrderBean> selectByMemberID(int memberID,boolean haveDelete) {
		String select_by_memberID = 
				"FROM MemberOrderBean WHERE memberID =:memberID AND haveDelete=:haveDelete ORDER BY memberDate DESC";
		List<MemberOrderBean> result =this.getSession()
							.createQuery(select_by_memberID)
							.setInteger("memberID",memberID)
							.setBoolean("haveDelete",haveDelete)
							.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberOrderBean> selecTByDateRange(int memberID,Date firstDate,Date lastDate) {
		String select_by_dateRange = 
			"from MemberOrderBean m where m.memberID = :memberID AND m.memberDate between :firstDate AND :lastDate AND haveDelete=false";
		List<MemberOrderBean> result =this.getSession()
									.createQuery(select_by_dateRange)
									.setInteger("memberID",memberID)
									.setDate("firstDate",firstDate)
									.setDate("lastDate",lastDate)
									.list();	
		return result;
	}

	@Override
	public boolean insert(MemberOrderBean memberOrderBean) {
		try {
			this.getSession().save(memberOrderBean);
		}
		catch (Exception e) {
		e.printStackTrace();
		return false;
		}
		return true;
	}

	@Override

	public boolean update(MemberOrderBean memberOrderBean) {
		try {
			this.getSession().saveOrUpdate(memberOrderBean);
		}
		catch (Exception e) {
		e.printStackTrace();
		return false;
		}
		return true;

	}

}