package com.onlineshop.backingbeans.product;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.ProductDAO;
import com.onlineshop.model.Product;


@SuppressWarnings("serial")
@ManagedBean(name="viewProductBB")
@ViewScoped
public class ViewProduct implements Serializable{
	private List<Product> products;
	
	@PostConstruct
	public void init(){
		try{
			products = (List<Product>)ProductDAO.listProducts();
		} catch (Exception e){
			e.printStackTrace();
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
