package model.MemberOrder;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface MemberOrderInterface {

	public abstract List<MemberOrderBean> selectByMemberID(int memberID);

	public abstract List<MemberOrderBean> selectByHaveDelete(int memberID, boolean haveDelete);

	public abstract List<MemberOrderBean> selecTByMemberDate(Date memberDate);

	public abstract MemberOrderBean insert(MemberOrderBean memberOrderBean);

	public abstract MemberOrderBean update(int orderID, int memberID, java.util.Date memberDate, double roomTotalSum, double memberSum, boolean haveDelete);

}
