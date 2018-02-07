/**
 * 
 */
package com.onlineshop.backingbeans.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.onlineshop.model.Product;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@ManagedBean(name="userCart")
@SessionScoped
public class UserCart implements Serializable{
	
	private List<Product> products;
	
	
	/**
	 * 
	 */
	public UserCart() {
		products = new ArrayList<Product>();
	}
	
	public void addProductToCart(Product product){
		if (!products.contains(product)){
			products.add(product);
		}
	}
	
	public void removeProductFromCart(Product product){
		if (products.contains(product)){
			products.remove(product);
		}
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

}
