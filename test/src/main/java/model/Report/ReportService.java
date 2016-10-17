package model.Report;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.misc.HibernateUtil;

public class ReportService {
	private  ReportDAO  reportDAO=new ReportDAO(HibernateUtil.getSessionFactory().getCurrentSession());
	
	private Session session=null;	  	 
	 public ReportService( Session session) {
		this.session = session;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			 Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			 ReportService dao=new ReportService(session);
			 
			 
			 HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}finally
		{
			// TODO Auto-generated catch block
			HibernateUtil.closeSessionFactory();
		}		
	}

public <T> List<T>  Show_ALL_Report()	
{
	return (List<T>)reportDAO.selectAll();
}
	
     public boolean insert(Object[] bean)
     {
	   ReportBean x=new ReportBean();
    	 x.setArtCode((int)bean[0]);
    	 x.setReportMemberID((int)bean[1]);
    	 x.setReportContent((String)bean[2]);
    	 x.setReportDate((Date)bean[3]);
     return  reportDAO.insert(x);	 
    }
	
	
	
}
