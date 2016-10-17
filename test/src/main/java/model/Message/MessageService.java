package model.Message;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import model.misc.HibernateUtil;

public class MessageService {
	private MessageDAO messageDAO=new  MessageDAO(HibernateUtil.getSessionFactory().getCurrentSession()) ;
	 private Session session=null;	  
	
	 public MessageService(Session session) {
		this.session = session;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			 Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            MessageService dao=new  MessageService(session);
             //System.out.println(dao.Show_ALL_Messages()); 
			 HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally
		 {
			// TODO Auto-generated catch block
			HibernateUtil.closeSessionFactory();
		}
	}

public  List<MessageBean>  Show_ALL_Messages()	
{
		return messageDAO.selectAll();
}
	
public List<MessageBean> Articles_Message_History_search(int artCode )
{

	return messageDAO.selectByartCode(artCode);
	
}
	
public boolean Message_insert(Object[] bean){
	MessageBean x=new MessageBean();
    x.setMemberID((int)bean[0]);
	x.setArtCode((int)bean[1]);
	x.setMsgContent((String)bean[2]);
    x.setMsgDate((Date)bean[3]);
    x.setGood((int)bean[4]);
    x.setBad((int)bean[5]);
    return 	messageDAO.insert(x);
}
/*必須傳入完整bean(含PK鍵)*/
public boolean Message_update(Object[] bean){
	MessageBean x=new MessageBean();
	x.setMsgCode((int)bean[0]);
	x.setMemberID((int)bean[1]);
	x.setArtCode((int)bean[2]);
	x.setMsgContent((String)bean[3]);
    x.setMsgDate((Date)bean[4]);
    x.setGood((int)bean[5]);
    x.setBad((int)bean[6]);
	return 	messageDAO.update(x);
}


	
}
