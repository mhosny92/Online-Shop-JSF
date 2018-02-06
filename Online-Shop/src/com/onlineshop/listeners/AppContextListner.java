package com.onlineshop.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.onlineshop.hibernate.HibernateUtil;


@WebListener
public class AppContextListner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.configureSessionFactory();
	}

	
}