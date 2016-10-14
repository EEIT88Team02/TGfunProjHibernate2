package model.BBQOrder;

import java.util.List;

public interface BBQOrderInterface {

	public abstract List<BBQOrderBean> selectByOrderID(int orderID);
	
	public abstract List<BBQOrderBean> selectByHaveDelete(boolean haveDelete);
	
	public abstract BBQOrderBean insert(BBQOrderBean bbqOrderBean);	
	
	public abstract BBQOrderBean update(BBQOrderBean bbqOrderBean);
	
}
