package jaumina.commons.util;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import java.io.IOException;
import org.hibernate.SessionFactory;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com
 *  Iniciando: Jueves 04 de agosto de 2016
 *  */

public class ConeccionHibernateFilter implements Filter {
	
	private SessionFactory sf;
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest servletFilter, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
	try {	
		this.sf.getCurrentSession().beginTransaction();
		chain.doFilter(servletFilter, servletResponse);
		this.sf.getCurrentSession().getTransaction().commit();
		this.sf.getCurrentSession().close();
	} catch (Throwable ex) {
		
		try {
			if (this.sf.getCurrentSession().getTransaction().isActive()) {
				this.sf.getCurrentSession().getTransaction().rollback();
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		throw new ServletException(ex.getMessage());
	}
	}
	
	@Override 
	public void init(FilterConfig conf) throws ServletException {
		this.sf = HibernateUtil.getSession();
	}
	
}