package model.Message;

import java.text.ParseException;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.Session;

import model.Member.MemberBean;
import model.Report.ReportBean;
import model.misc.HibernateUtil;

@Entity
@Table(name = "MESSAGE")
public class MessageBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int msgCode;
	private int memberID;
	private int reportCount;
	private String messageTopic;
	private String messageContent;
	private java.util.Date askDate;
	private String reply;
	private java.util.Date replyDate;
	private String haveAppeal;
	private String appealContent;
	private String reportReply;

	@OneToMany(	mappedBy = "messages" ,
				cascade = { CascadeType.REMOVE })
	private Set<ReportBean> reports;

	public Set<ReportBean> getReports() {
		return reports;
	}

	public void setReports(Set<ReportBean> reports) {
		this.reports = reports;
	}

	@ManyToOne
	@JoinColumn(name = "MEMBERID" ,
				referencedColumnName = "MEMBERID" ,
				insertable = false ,
				updatable = false)
	private MemberBean members;

	public MemberBean getMembers() {
		return members;
	}

	public void setMembers(MemberBean members) {
		this.members = members;
	}

	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

//			 MessageBean insert = new MessageBean();
//			 insert.setMemberID(1);
//			 insert.setReportCount(0);
//			 insert.setMessageTopic("ccc");
//			 insert.setMessageContent("aaa");
//			 insert.setAskDate(new java.util.Date());
//			 insert.setHaveAppeal("N");
//			 session.save(insert);

//			 MessageBean select = (MessageBean) session.get(MessageBean.class,1);
//			 System.out.println("select=" + select);

//			 MessageBean select = (MessageBean) session.get(MessageBean.class,1);
//			 System.out.println(select.getReports());

//			 MessageBean select = (MessageBean) session.get(MessageBean.class,1);
//			 System.out.println(select.getMembers());

			// MessageBean select = (MessageBean) session.get(MessageBean.class, 2);
			// select.setMessageTopic("ddd");
			// select.setMessageContent("eee");
			// select.setAskDate(new java.util.Date());

			// MessageBean select = (MessageBean) session.get(MessageBean.class, 2);
			// session.delete(select);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	@Override
	public String toString() {
		return "MessageBean [msgCode=" + msgCode + ", memberID=" + memberID + ", reportCount=" + reportCount + ", messageTopic=" + messageTopic + ", messageContent=" + messageContent + ", askDate="
				+ askDate + ", reply=" + reply + ", replyDate=" + replyDate + ", haveAppeal=" + haveAppeal + ", appealContent=" + appealContent + ", reportReply=" + reportReply + "]";
	}

	public int getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(int msgCode) {
		this.msgCode = msgCode;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public String getMessageTopic() {
		return messageTopic;
	}

	public void setMessageTopic(String messageTopic) {
		this.messageTopic = messageTopic;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public java.util.Date getAskDate() {
		return askDate;
	}

	public void setAskDate(java.util.Date askDate) {
		this.askDate = askDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public java.util.Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(java.util.Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getHaveAppeal() {
		return haveAppeal;
	}

	public void setHaveAppeal(String haveAppeal) {
		this.haveAppeal = haveAppeal;
	}

	public String getAppealContent() {
		return appealContent;
	}

	public void setAppealContent(String appealContent) {
		this.appealContent = appealContent;
	}

	public String getReportReply() {
		return reportReply;
	}

	public void setReportReply(String reportReply) {
		this.reportReply = reportReply;
	}

}
