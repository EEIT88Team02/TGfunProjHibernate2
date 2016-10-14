package model.OrderRoomInfo;

import java.util.List;

public interface OrderRoomInfoInterface {
	
	public abstract List<OrderRoomInfoBean> selectByOrderID(int orderID);
	
	public abstract OrderRoomInfoBean insert(OrderRoomInfoBean orderRoomInfoBean);
}
