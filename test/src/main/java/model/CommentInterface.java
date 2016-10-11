package model;

import java.util.Date;
import java.util.List;

public interface CommentInterface {

	// select

	/* 王荐進(頭) */
	public abstract List<CommentBean> selectAll();

	public abstract List<CommentBean> selectByMemberID(int memberID);

	public abstract List<CommentBean> selectByCommentID(int commentID);

	public abstract List<CommentBean> selectByCommentDate(Date commentDate);

	public abstract List<CommentBean> selectByReply(String reply);
	/* 王荐進(尾) */

	
	// insert

	/* 王荐進(頭) */
	public abstract boolean insert(CommentBean commentBean);
	/* 王荐進(尾) */

	
	// update

	/* 王荐進(頭) */
	public abstract CommentBean update(int CommentID, int memberID, String commentContent, java.util.Date commentDate, String reply);
	/* 王荐進(尾) */

}
