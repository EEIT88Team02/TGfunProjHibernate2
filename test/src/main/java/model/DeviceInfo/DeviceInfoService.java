package model.DeviceInfo;

import org.hibernate.Session;

import misc.HibernateUtil;
import model.MemberOrder.MemberOrderDAO;

public class DeviceInfoService {

	private DeviceInfoDAO deviceInfoDAO;

	public DeviceInfoService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		deviceInfoDAO = new DeviceInfoDAO(session);
	}
	
	public DeviceInfoBean selectByDeviceID(int deviceID) {
		return deviceInfoDAO.selectByDeviceID(deviceID);
	}
	
	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
			
			DeviceInfoService service = new DeviceInfoService();
			DeviceInfoBean result=service.selectByDeviceID(1);
			System.out.println(result);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
