/**
 * 
 */
package com.onlineshop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.onlineshop.hibernate.HibernateUtil;
import com.onlineshop.model.GroupOption;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
public class GroupOptionDAO extends CRUDBase implements Serializable{
	public static GroupOption loadOptionByID(int ID) {

		HibernateUtil.startSession();
		GroupOption sup = HibernateUtil.getSession().get(GroupOption.class, ID);
		HibernateUtil.commitAndCloseSession();
		return sup;
	}

	@SuppressWarnings("unchecked")
	public static List<GroupOption> listOptions() {
		HibernateUtil.startSession();
		String hql = "from GroupOption order by ID desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		List<GroupOption> oList = (ArrayList<GroupOption>) query.list();
		HibernateUtil.commitAndCloseSession();
		return oList;
	}

	public static GroupOption createOption() {
		return new GroupOption();
	}

}
