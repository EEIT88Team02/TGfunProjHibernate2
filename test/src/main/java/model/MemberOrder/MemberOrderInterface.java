package model.MemberOrder;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface MemberOrderInterface {

	
	public abstract List<Object[]> selectByMemberID(int memberID);
	

	public abstract List<MemberOrderBean> selectByHaveDelete(int memberID, boolean haveDelete);


	public abstract List<MemberOrderBean> selecTByDateRange(int memberID,String firstDate,String lastDate);


	public abstract MemberOrderBean insert(MemberOrderBean memberOrderBean);

	public abstract MemberOrderBean update(MemberOrderBean memberOrderBean);

}
