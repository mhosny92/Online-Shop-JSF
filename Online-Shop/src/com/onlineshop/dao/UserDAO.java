/**
 * 
 */
package com.onlineshop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.onlineshop.hibernate.HibernateUtil;
import com.onlineshop.model.User;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
public class UserDAO extends CRUDBase implements Serializable{
	public static User loadUserByID(int ID) {

		HibernateUtil.startSession();
		User user = HibernateUtil.getSession().get(User.class, ID);
		HibernateUtil.commitAndCloseSession();
		return user;
	}

	@SuppressWarnings("unchecked")
	public static List<User> listUsers() {
		HibernateUtil.startSession();
		String hql = "from User order by ID desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		List<User> uList = (ArrayList<User>) query.list();
		HibernateUtil.commitAndCloseSession();
		return uList;
	}
	
	public static User validUser(String name, String pswd){
		HibernateUtil.startSession();
		String hql = "from User where name = :name and password = :pswd";
		Query query = HibernateUtil.getSession().createQuery(hql);
		query.setParameter("name", name).setParameter("pswd", pswd);
		User user = (User)query.uniqueResult();
		HibernateUtil.commitAndCloseSession();
		return user;
	}

	public static User createUser() {
		return new User();
	}
}
