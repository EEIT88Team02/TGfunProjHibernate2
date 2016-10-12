package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import model.misc.HibernateUtil;

@Entity
@Table(name = "ROOMINFO")
public class RoomInfoBean {

	@Id
	private int roomCode;       // 房間代號
	private String roomName;    // 房間名稱
	private double roomPrice;    // 房間金額
	private int housing;        // 可住人數
	private String introduction;// 房間介紹
	private String device;      // 房間設備
	private String smoke;       // 是否吸菸
	private byte[] roomImage;   // 房間圖片

	@Override
	public String toString() {
		return "RoomInfoBean [roomCode=" + roomCode + ", roomName=" + roomName + ", roomPrice=" + roomPrice + ", housing=" + housing + ", introduction=" + introduction + ", device=" + device
				+ ", smoke=" + smoke + ", roomImage=" + Arrays.toString(roomImage) + "]";
	}

	public int getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getHousing() {
		return housing;
	}

	public void setHousing(int housing) {
		this.housing = housing;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSmoke() {
		return smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public byte[] getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(byte[] roomImage) {
		this.roomImage = roomImage;
	}

	public static void main(String[] args) throws IOException {

		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			/* 查詢單筆ok */
//			 RoomInfoBean select=(RoomInfoBean)session.get(RoomInfoBean.class, 101);
//			 System.out.println(select);

			/* 查詢全部資訊ok */
//			 SQLQuery query=session.createSQLQuery("select * from RoomInfo");
//			 query.addEntity(RoomInfoBean.class); //編譯陣列資料
//			 List<RoomInfoBean> beans=query.list();
//			 System.out.println(beans);

			/* 新增資料ok */
//			 RoomInfoBean insert = new RoomInfoBean();
//			 insert.setRoomCode(102);
//			 insert.setRoomName("巴哈姆特");
//			 insert.setRoomPrice(4000);
//			 insert.setHousing(2);
//			 insert.setIntroduction("舒適清閒");
//			 insert.setDevice("wifi");
//			 insert.setSmoke("N");
//			 session.save(insert);

			/* 刪除ok */
//			 RoomInfoBean bean=(RoomInfoBean)session.get(RoomInfoBean.class, 102);
//			 session.delete(bean);

			/* 修改ok */
//			 RoomInfoBean bean=(RoomInfoBean)session.get(RoomInfoBean.class, 102);
//			 bean.setRoomPrice(50000);
//			 bean.setHousing(3);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();

		}
	}
}
