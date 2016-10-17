package model.OrderRoomInfo;

import java.util.List;

import model.MemberOrder.MemberOrderBean;

public interface OrderRoomInfoInterface {
	
	public abstract List<OrderRoomInfoBean> selectByOrderID(int orderID);
	
	public abstract List<OrderRoomInfoBean> selecTByIn_OutDate(String inDate,String outDate,int roomCode);
	
	public abstract boolean insert(OrderRoomInfoBean orderRoomInfoBean);
}
