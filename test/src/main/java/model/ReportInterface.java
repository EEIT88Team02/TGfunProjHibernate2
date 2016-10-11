package model;

import java.util.List;

public interface ReportInterface {

	// select
	/* 王荐進(頭) */
	public abstract List<ReportBean> selectAll();

	public abstract List<ReportBean> selectByReportMemberID(int reportMemberID);

	public abstract List<ReportBean> selectByMsgCode(int msgCode);
	/* 王荐進(尾) */
	
	
	// insert
	/* 王荐進(頭) */
	public abstract boolean insert(ReportBean reportBean);
	/* 王荐進(尾) */
	
	
	// update
	/* 王荐進(頭) */
	public abstract ReportBean update(int reportID, int msgCode, int reportMemberID, String reportContent);
	/* 王荐進(尾) */
	
	
	// delete
	/* 王荐進(頭) */
	public abstract boolean delete(int reportID);
	/* 王荐進(尾) */
}
