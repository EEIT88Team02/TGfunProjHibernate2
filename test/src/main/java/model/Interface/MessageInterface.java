package model.Interface;

import java.util.Date;
import java.util.List;

import model.MessageBean;

public interface MessageInterface {

	// select
	/* 王荐進(頭) */
	public abstract List<MessageBean> selectAll();

	public abstract List<MessageBean> selectByAskDate(Date askDate);

	public abstract List<MessageBean> selectByReplyDate(Date replydate);
	/* 王荐進(尾) */
	
	
	// insert
	/* 王荐進(頭) */
	public abstract boolean insert(MessageBean messageBean);
	/* 王荐進(尾) */
	
	
	// update
	/* 王荐進(頭) */
	public abstract MessageBean update(int msgCode, int memberID, int reportCount, String messageTopic, String messageContent, java.util.Date askDate, String reply, java.util.Date replyDate,String haveAppeal, String appealContent, String reportReply);
	/* 王荐進(尾) */
}
