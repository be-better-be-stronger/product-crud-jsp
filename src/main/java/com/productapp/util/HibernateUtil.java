package com.productapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
            // Nạp file hibernate.cfg.xml và build session factory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Lỗi khởi tạo Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
	// Lấy ra 1 SessionFactory để mở Session
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
