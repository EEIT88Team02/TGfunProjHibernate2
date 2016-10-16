package model.DeviceInfo;

import java.util.List;

import org.hibernate.Session;

import model.RoomDeviceInfo.RoomDeviceInfoBean;
import model.RoomDeviceInfo.RoomDeviceInfoDAO;
import model.misc.HibernateUtil;

public class DeviceInfoDAO implements DeviceInfoInterface {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
			DeviceInfoDAO dao = new DeviceInfoDAO(session);
			DeviceInfoBean result=dao.selectByDeviceID(1);
			System.out.println(result);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	private Session session = null;

	public DeviceInfoDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceInfoBean selectByDeviceID(int deviceID) {
		String select_by_deviceID = "FROM DeviceInfoBean WHERE deviceID =:deviceID";
		DeviceInfoBean result = (DeviceInfoBean) this.getSession()
										.createQuery(select_by_deviceID)
										.setInteger("deviceID",deviceID)
										.uniqueResult();
		return result;
	}

}
