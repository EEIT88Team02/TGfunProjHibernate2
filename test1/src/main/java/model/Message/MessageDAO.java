package model.Message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Message;

import model.misc.HibernateUtil;

public class MessageDAO implements MessageInterface {

	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			MessageDAO messageDAO = new MessageDAO(session);

			 System.out.println(messageDAO.selectAll());

			// System.out.println(messageDAO.selectByAskDate("2016-08-08 00:00:00"));

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	private Session session = null;

	public MessageDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	@Override
	public List<MessageBean> selectAll() {
		Query query = this.getSession().createSQLQuery("select * from Message ORDER BY askDate DESC").addEntity(MessageBean.class);
		return (List<MessageBean>) query.list();
	}

	@Override
	public List<MessageBean> selectByAskDate(Date askDate) {
		Query query = this.getSession().createQuery("FROM MessageBean WHERE AskDate = :askDate ");
		query.setDate("askDate",askDate);
		return (List<MessageBean>) query.list();
	}

	@Override
	public List<MessageBean> selectByReplyDate(Date replydate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(MessageBean messageBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MessageBean update(int msgCode, int memberID, int reportCount, String messageTopic, String messageContent, Date askDate, String reply, Date replyDate, String haveAppeal,
			String appealContent, String reportReply) {
		// TODO Auto-generated method stub
		return null;
	}

}
