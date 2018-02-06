/**
 * 
 */
package com.onlineshop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.onlineshop.hibernate.HibernateUtil;
import com.onlineshop.model.OptionsGroup;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
public class OptionsGroupDAO extends CRUDBase implements Serializable{
	public static OptionsGroup loadOptionsGroupByID(int ID) {

		HibernateUtil.startSession();
		OptionsGroup sup = HibernateUtil.getSession().get(OptionsGroup.class, ID);
		HibernateUtil.commitAndCloseSession();
		return sup;
	}

	@SuppressWarnings("unchecked")
	public static List<OptionsGroup> listOptionsGroups() {
		HibernateUtil.startSession();
		String hql = "from OptionsGroup order by ID desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		List<OptionsGroup> ogList = (ArrayList<OptionsGroup>) query.list();
		HibernateUtil.commitAndCloseSession();
		return ogList;
	}

	public static OptionsGroup createOptionsGroup() {
		return new OptionsGroup();
	}

}
