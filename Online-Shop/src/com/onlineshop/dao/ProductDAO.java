/**
 * 
 */
package com.onlineshop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.onlineshop.hibernate.HibernateUtil;
import com.onlineshop.model.Product;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
public class ProductDAO extends CRUDBase implements Serializable{
	public static Product loadProductByID(int ID) {

		HibernateUtil.startSession();
		Product sup = HibernateUtil.getSession().get(Product.class, ID);
		HibernateUtil.commitAndCloseSession();
		return sup;
	}

	@SuppressWarnings("unchecked")
	public static List<Product> listProducts() {
		HibernateUtil.startSession();
		String hql = "from Product order by ID desc";
		Query query = HibernateUtil.getSession().createQuery(hql);
		List<Product> pList = (ArrayList<Product>) query.list();
		HibernateUtil.commitAndCloseSession();
		return pList;
	}

	public static Product createProduct() {
		return new Product();
	}


}
