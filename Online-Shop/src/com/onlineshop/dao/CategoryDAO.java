/**
 * 
 */
package com.onlineshop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.onlineshop.hibernate.HibernateUtil;
import com.onlineshop.model.Category;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
public class CategoryDAO extends CRUDBase implements Serializable{
	public static Category loadCategoryByID(int ID){
		
		HibernateUtil.startSession();
		Category cat = HibernateUtil.getSession().get(Category.class, ID);
		HibernateUtil.commitAndCloseSession();
		return cat;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Category> listCategories(){
		HibernateUtil.startSession();
		String hql = "from Category order by ID desc"; //  ORDER BY creationDate DESC
		Query query = HibernateUtil.getSession().createQuery(hql);
		List<Category> cList = (ArrayList<Category>) query.list();
		HibernateUtil.commitAndCloseSession();
		return cList;
	}
	
	public static Category createCategory(){
		return new Category();
	}
}
