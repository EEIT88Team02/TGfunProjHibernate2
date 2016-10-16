package model.MemberOrder;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface MemberOrderInterface {

	
	public abstract List<MemberOrderBean> selectByMemberID(int memberID,boolean haveDelete);

	public abstract List<MemberOrderBean> selecTByDateRange(int memberID,String firstDate,String lastDate);

	public abstract boolean insert(MemberOrderBean memberOrderBean);

	public abstract MemberOrderBean updateHaveDelete(MemberOrderBean memberOrderBean);

}
