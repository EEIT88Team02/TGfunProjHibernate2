package model.Comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import model.Member.MemberBean;
import model.misc.HibernateUtil;

@Entity
@Table(name = "COMMENT")
public class CommentBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CommentID;
	private int memberID;
	private String commentContent;
	private java.util.Date commentDate;
	private String reply;

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

			// CommentBean insert = new CommentBean();
			// insert.setMemberID(1);
			// insert.setCommentContent("hello!");
			// insert.setCommentDate(new Date());
			// session.save(insert);

			// CommentBean select = (CommentBean) session.get(CommentBean.class, 1);
			// System.out.println("select=" + select);

			// CommentBean select = (CommentBean) session.get(CommentBean.class, 1);
			// System.out.println("select=" + select.getMembers());

			// CommentBean select = (CommentBean) session.get(CommentBean.class,1);
			// select.setReply("hi");

			// CommentBean select = (CommentBean) session.get(CommentBean.class,2);
			// session.delete(select);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	@Override
	public String toString() {
		return "CommentBean [CommentID=" + CommentID + ", memberID=" + memberID + ", commentContent=" + commentContent + ", commentDate=" + commentDate + ", reply=" + reply + "]";
	}

	public int getCommentID() {
		return CommentID;
	}

	public void setCommentID(int commentID) {
		CommentID = commentID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public java.util.Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(java.util.Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

}
