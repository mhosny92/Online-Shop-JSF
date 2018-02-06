/**
 * 
 */
package com.onlineshop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.onlineshop.hibernate.HibernateUtil;
import com.onlineshop.model.Supplier;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
public class SupplierDAO extends CRUDBase implements Serializable {
	public static Supplier loadSupplierByID(int ID) {

		HibernateUtil.startSession();
		Supplier sup = HibernateUtil.getSession().get(Supplier.class, ID);
		HibernateUtil.commitAndCloseSession();
		return sup;
	}

	@SuppressWarnings("unchecked")
	public static List<Supplier> listSuppliers() {
		HibernateUtil.startSession();
		String hql = "from Supplier order by ID desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		List<Supplier> sList = (ArrayList<Supplier>) query.list();
		HibernateUtil.commitAndCloseSession();
		return sList;
	}

	public static Supplier createSupplier() {
		return new Supplier();
	}

}
