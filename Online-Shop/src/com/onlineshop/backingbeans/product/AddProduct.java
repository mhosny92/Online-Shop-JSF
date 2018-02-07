package com.onlineshop.backingbeans.product;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.dao.ProductDAO;
import com.onlineshop.model.Category;
import com.onlineshop.model.Product;
import com.onlineshop.util.OnlineStoreUtil;

@SuppressWarnings("serial")
@ManagedBean(name = "addProductBB")
@ViewScoped
public class AddProduct implements Serializable {

	private Product product;
	private List<Category> categories;
	private UploadedFile thumb;
	private UploadedFile image;

	@PostConstruct
	public void init() {
		try {
			product = ProductDAO.createProduct();
			categories = (List<Category>) CategoryDAO.listCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveProduct() throws Exception {
		try {
			product.setImage(OnlineStoreUtil.uploadImage(image));
			product.setThumb(OnlineStoreUtil.uploadImage(thumb));
			ProductDAO.save(product);
			product = ProductDAO.createProduct();
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Success", "Prouduct added");
			context.addMessage("msgs", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the thumb
	 */
	public UploadedFile getThumb() {
		return thumb;
	}

	/**
	 * @param thumb
	 *            the thumb to set
	 */
	public void setThumb(UploadedFile thumb) {
		this.thumb = thumb;
	}

	/**
	 * @return the image
	 */
	public UploadedFile getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
