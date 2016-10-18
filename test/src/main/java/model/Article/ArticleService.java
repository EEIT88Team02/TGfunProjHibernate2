package model.Article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import misc.HibernateUtil;
import model.Message.MessageBean;
import model.Message.MessageDAO;

public class ArticleService {
 private ArticleDAO articleDAO=new  ArticleDAO(HibernateUtil.getSessionFactory().getCurrentSession()) ;
 private Session session=null;	  
	
 
 public ArticleService( Session session) {
	this.session = session;
}


public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		 Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		 ArticleService dao=new ArticleService(session); 
		 
		// List<Object[]> m=dao.Show_ALL_articles();
	/*List<Object[]> 處理*/
//		 if(m!=null)
//		 {
//		 for(int u=0;u<m.size();u++)	
//		 {	
//		 	Object[] x=m.get(u);
//		 	int i=0; 
//		 	for(Object vv :x)	 
//		 	 {
//		 		 if(i==0)
//		 		 {
//		 			 ArticleBean df=(ArticleBean)vv;	
//		 			  System.out.println(df);
//		 		 }else{
//		 		  MessageBean dj= ( MessageBean)vv;
//		 	   System.out.println(dj);
//		 		 }
//		 	   ++i;
//		 	  }
//		 }	
//	 }
		
//	List<Object> c=dao.DateSort(true);		 
	
	 	 
		 
		 
		 HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	}finally
	 {
		// TODO Auto-generated catch block
		HibernateUtil.closeSessionFactory();
	}
	  
       
	}

public   List<Object[]>   Show_ALL_articles()
{
	List<ArticleBean> test1= articleDAO.selectAll();
	if(!test1.isEmpty()){
	List<Object[]> c=new ArrayList<>();
	MessageDAO messageDAO=new  MessageDAO(HibernateUtil.getSessionFactory().getCurrentSession()) ;	
	
	for(ArticleBean mm:test1)
	{
       int x=mm.getArtCode();
      List <MessageBean> y= messageDAO.selectByartCode(x);
       int len=y.size();  
      Object[] cc=new Object[len+1];
      cc[0]=mm;
      for(int i=0 ,j=1;i<len;++j,++i)
      {
    	  MessageBean yy=y.get(i);  
    	 cc[j]=yy;
      }
      c.add(cc);  
	} 
	 return c;
	}
	return null; 
}

public  <T> List<T> accordance_with_gap_date(Date date1,Date date2){
	List<T> m=new ArrayList<>();
	List<ArticleBean> u=articleDAO.selectByartDate(date1, date2);
	
	
	return (List<T>) articleDAO.selectByartDate(date1, date2);
}

public <T> List<T> DateSort(boolean BOOL)
{
	return (List<T>) articleDAO.selectBySortDate(BOOL);
}

public <T> List<T> SearchByTopic(String ArtTopic)
{
	return  (List<T>) articleDAO.selectByArtTopic(ArtTopic);
}

public boolean   whetherHaveAppeal(String name)
{
	return articleDAO.selectByHaveAppeal(name);
}

public boolean whetherhaveprocess(String name)
{
	 return articleDAO.selectByhaveprocess(name);
}

public boolean Articleinsert(Object[] bean)
{
	ArticleBean x=new ArticleBean();
		x.setMemberID((int)bean[0]);
	  x.setReportCount((int)bean[1]);
	  x.setArtTopic((String)bean[2]);
	  x.setArtContent((String)bean[3]);
	  x.setArtDate((Date)bean[4]);
	  x.setAppealDate((Date)bean[5]);
	  x.setHaveAppeal((boolean)bean[6]);
	  x.setAppealContent((String)bean[7]);
	  x.setHaveProcess((boolean)bean[8]);
	  x.setProcessDate((Date)bean[9]);
	  x.setReportReply((String)bean[10]);
	  x.sethaveDelete((boolean)bean[11]);
	return  articleDAO.insert(x);
}

public  boolean  Articleupdate(Object[] bean)
{
	ArticleBean y=new ArticleBean();
	y.setMemberID((int)bean[0]);
	  y.setReportCount((int)bean[1]);
	  y.setArtTopic((String)bean[2]);
	  y.setArtContent((String)bean[3]);
	  y.setArtDate((Date)bean[4]);
	  y.setAppealDate((Date)bean[5]);
	  y.setHaveAppeal((boolean)bean[6]);
	  y.setAppealContent((String)bean[7]);
	  y.setHaveProcess((boolean)bean[8]);
	  y.setProcessDate((Date)bean[9]);
	  y.setReportReply((String)bean[10]);
	  y.sethaveDelete((boolean)bean[11]);
	articleDAO.update(y);
    return true;
}

}
