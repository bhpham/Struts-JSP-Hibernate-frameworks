package net.mv.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private HibernateUtil() {}
	
	public static Session getSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	
	
	
}
