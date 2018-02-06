package com.onlineshop.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;
	private static Session session = null;
	
	
	public static void configureSessionFactory(){
		if (sessionFactory == null){
			Configuration config = new Configuration();
			config.configure();
			
			config.addAnnotatedClass(com.onlineshop.model.User.class);
			config.addAnnotatedClass(com.onlineshop.model.Category.class);
			config.addAnnotatedClass(com.onlineshop.model.Supplier.class);
			config.addAnnotatedClass(com.onlineshop.model.Product.class);
			config.addAnnotatedClass(com.onlineshop.model.OptionsGroup.class);
			config.addAnnotatedClass(com.onlineshop.model.GroupOption.class);
			config.addAnnotatedClass(com.onlineshop.model.Order.class);
			
			HibernateUtil.serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
					config.getProperties()).build();
			HibernateUtil.sessionFactory = config.buildSessionFactory(serviceRegistry);
		}
	}
	
	public static void closeSessionFactory(){
		sessionFactory.close();
	}
	
	public static Session getSession(){
		return HibernateUtil.session;
	}
	public static void startSession(){
		HibernateUtil.session = HibernateUtil.sessionFactory.openSession();
		HibernateUtil.session.beginTransaction();
	}
	public static void commitAndCloseSession(){
		HibernateUtil.session.getTransaction().commit();
		HibernateUtil.session.close();
	}
	/*
	public static void startSession(){
		HibernateUtil.session = HibernateUtil.sessionFactory.openSession();
		HibernateUtil.session.beginTransaction();
	}
	public static void commitAndCloseSession(){
		if (HibernateUtil.session != null && HibernateUtil.session.getTransaction() != null)
			HibernateUtil.session.getTransaction().commit();
		HibernateUtil.session.close();
	}
	*/
}
