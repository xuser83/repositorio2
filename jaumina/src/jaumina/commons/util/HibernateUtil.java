package jaumina.commons.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**@author Diego Benitez 
 * 
 *  xuser83@hotmail.com*/

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory session = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
		return new AnnotationConfiguration()
		.configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("No se conecto!:\n " + e);
			throw new ExceptionInInitializerError();
		}
	}
	
	
	
	public static SessionFactory getSession() {
		return session;
	}
}
