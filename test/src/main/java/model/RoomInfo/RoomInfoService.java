package model.RoomInfo;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import misc.HibernateUtil;
import model.MemberOrder.MemberOrderDAO;
@Component
public class RoomInfoService {
	
	@Autowired
	private RoomInfoDAO roomInfoDAO;

	public RoomInfoService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		roomInfoDAO = new RoomInfoDAO(session);
	}
	
	public RoomInfoBean selectByRoomCode(int roomCode) {
		return roomInfoDAO.selectByRoomCode(roomCode);
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			RoomInfoService service = new RoomInfoService();
			RoomInfoBean result = service.selectByRoomCode(101);
			System.out.println(result);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
