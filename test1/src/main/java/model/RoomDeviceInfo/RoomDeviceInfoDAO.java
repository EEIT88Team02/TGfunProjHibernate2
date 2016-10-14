package model.RoomDeviceInfo;

import java.util.List;

import org.hibernate.Session;

import model.OrderRoomInfo.OrderRoomInfoBean;
import model.RoomInfo.RoomInfoBean;
import model.RoomInfo.RoomInfoDAO;
import model.misc.HibernateUtil;

public class RoomDeviceInfoDAO implements RoomDeviceInfoInterface {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
			RoomDeviceInfoDAO dao = new RoomDeviceInfoDAO(session);
			List<RoomDeviceInfoBean> result=dao.selectByRoomCode(101);
			System.out.println(result);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	private Session session = null;

	public RoomDeviceInfoDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomDeviceInfoBean> selectByRoomCode(int roomCode) {
		String select_by_roomCode = "FROM RoomDeviceInfoBean WHERE roomCode =:roomCode";
		List<RoomDeviceInfoBean> result = this.getSession()
										.createQuery(select_by_roomCode)
										.setInteger("roomCode",roomCode)
										.list();
		return result;
	}
}
