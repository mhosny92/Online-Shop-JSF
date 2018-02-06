package com.onlineshop.backingbeans.category;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.model.Category;

@SuppressWarnings("serial")
@ManagedBean(name="viewCategoryBB")
@RequestScoped
public class ViewCategory implements Serializable{
	private List<Category> categories;
	
	@PostConstruct
	public void init(){
		try {
			categories = (List<Category>)CategoryDAO.listCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ViewCategory(){}
	
	
	

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
