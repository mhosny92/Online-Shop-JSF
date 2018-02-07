/**
 * 
 */
package com.onlineshop.backingbeans.product;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.hibernate.HibernateUtil;
import com.onlineshop.model.Category;
import com.onlineshop.model.Product;

/**
 * @author Mahmoud
 *
 */

@SuppressWarnings("serial")
@ManagedBean(name="browseProducts")
@ViewScoped
public class BrowseProducts implements Serializable{
	
	private List<Product> products;
	private List<Category> categories;
	private Category selectedCategory;
	private Product selectedProduct;
	
	@PostConstruct
	public void init(){
		categories = CategoryDAO.listCategories();
	}
	
	public void categoryChangedlistener(){
		HibernateUtil.startSession();
		HibernateUtil.getSession().refresh(selectedCategory);
		this.products = selectedCategory.getProducts();
		HibernateUtil.commitAndCloseSession();
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

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

	/**
	 * @return the selectedCategory
	 */
	public Category getSelectedCategory() {
		return selectedCategory;
	}

	/**
	 * @param selectedCategory the selectedCategory to set
	 */
	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	/**
	 * @return the selectedProduct
	 */
	public Product getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	
	
	
	
	

}
