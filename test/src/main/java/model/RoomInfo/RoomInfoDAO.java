package model.RoomInfo;

import java.util.List;

import org.hibernate.Session;

import model.OrderRoomInfo.OrderRoomInfoBean;
import model.misc.HibernateUtil;

public class RoomInfoDAO implements RoomInfoInterface {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
			RoomInfoDAO dao = new RoomInfoDAO(session);
			RoomInfoBean result=dao.selectByRoomCode(101);
			System.out.println(result);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

	private Session session = null;

	public RoomInfoDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RoomInfoBean selectByRoomCode(int roomCode) {
		String select_by_roomCode = 
				"FROM RoomInfoBean WHERE roomCode =:roomCode";
		RoomInfoBean result =(RoomInfoBean) this.getSession()
											.createQuery(select_by_roomCode)
											.setInteger("roomCode",roomCode)
											.uniqueResult();
		return result;
	}

}
