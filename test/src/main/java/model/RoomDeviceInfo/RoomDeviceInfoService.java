package model.RoomDeviceInfo;

import java.util.List;

import org.hibernate.Session;

import model.MemberOrder.MemberOrderDAO;
import model.misc.HibernateUtil;

public class RoomDeviceInfoService {

	private RoomDeviceInfoDAO roomDeviceInfoDAO;

	public RoomDeviceInfoService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		roomDeviceInfoDAO = new RoomDeviceInfoDAO(session);
	}
	
	public List<RoomDeviceInfoBean> selectByRoomCode(int roomCode) {
		return roomDeviceInfoDAO.selectByRoomCode(roomCode);
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

//			RoomDeviceInfoService service= new RoomDeviceInfoService();
//			List<RoomDeviceInfoBean> result = service.selectByRoomCode(101);
//			System.out.println(result);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
