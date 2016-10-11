package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.Session;

import model.misc.HibernateUtil;

@Entity
@Table(	name = "REPORT" ,
		uniqueConstraints = { @UniqueConstraint(columnNames = { "REPORTMEMBERID", "MSGCODE" }) })
public class ReportBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportID;
	private int msgCode;
	private int reportMemberID;
	private String reportContent;

	@ManyToOne
	@JoinColumn(name = "MSGCODE" ,
				referencedColumnName = "MSGCODE" ,
				insertable = false ,
				updatable = false)
	private MessageBean messages;

	public MessageBean getMessages() {
		return messages;
	}

	public void setMessages(MessageBean messages) {
		this.messages = messages;
	}

	@ManyToOne
	@JoinColumn(name = "REPORTMEMBERID" ,
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

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			// ReportBean insert = new ReportBean();
			// insert.setMsgCode(1);
			// insert.setReportMemberID(2);
			// insert.setMemberID(1);
			// insert.setReportContent("");
			// session.save(insert);

			// ReportBean select = (ReportBean) session.get(ReportBean.class,1);
			// System.out.println("select=" + select);

			// ReportBean select = (ReportBean) session.get(ReportBean.class,1);
			// System.out.println(select.getMembers());

			// ReportBean select = (ReportBean) session.get(ReportBean.class,1);
			// select.setReportContent("aaa");

			// ReportBean select = (ReportBean) session.get(ReportBean.class,1);
			// session.delete(select);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	@Override
	public String toString() {
		return "ReportBean [reportID=" + reportID + ", msgCode=" + msgCode + ", reportMemberID=" + reportMemberID + ", reportContent=" + reportContent + "]";
	}

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public int getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(int msgCode) {
		this.msgCode = msgCode;
	}

	public int getReportMemberID() {
		return reportMemberID;
	}

	public void setReportMemberID(int reportMemberID) {
		this.reportMemberID = reportMemberID;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

}
