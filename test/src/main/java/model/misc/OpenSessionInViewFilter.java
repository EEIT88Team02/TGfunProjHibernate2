package model.misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.misc.HibernateUtil;

@WebFilter(
		urlPatterns={"/*"}
)
public class OpenSessionInViewFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		try {
			System.out.println("Filter begin");
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			System.out.println("Filter end");
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
			chain.doFilter(request, response);
		}
	}
	private FilterConfig filterConfig;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	public void destroy() {

	}
}
