package model.misc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.misc.HibernateUtil;

@WebListener
public class SessionFactoryListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Web App started");
		HibernateUtil.getSessionFactory();
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.closeSessionFactory();
		System.out.println("Web App shutted down");
	}
}
