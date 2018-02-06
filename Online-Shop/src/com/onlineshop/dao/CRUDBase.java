package com.onlineshop.dao;

import com.onlineshop.hibernate.HibernateUtil;

public abstract class CRUDBase {
	public static void save(Object obj){
		HibernateUtil.startSession();
		HibernateUtil.getSession().save(obj);
		HibernateUtil.commitAndCloseSession();
	}
	public static void delete(Object obj){
		HibernateUtil.startSession();
		HibernateUtil.getSession().delete(obj);
		HibernateUtil.commitAndCloseSession();
	}
	public static void update(Object obj){
		HibernateUtil.startSession();
		HibernateUtil.getSession().update(obj);
		HibernateUtil.commitAndCloseSession();
	}
}
