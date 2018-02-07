package com.onlineshop.backingbeans.category;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.model.Category;
import com.onlineshop.util.OnlineStoreUtil;

@SuppressWarnings("serial")
@ManagedBean(name = "addCategoryBB")
@ViewScoped
public class AddCategory implements Serializable {
	private Category category;
	private UploadedFile thumb;
	private UploadedFile image;

	@PostConstruct
	public void init() {
		category = CategoryDAO.createCategory();
	}

	public AddCategory() {
	}

	public void saveCategory() throws Exception {
		try {
			category.setImage(OnlineStoreUtil.uploadImage(image));
			category.setThumb(OnlineStoreUtil.uploadImage(thumb));
			CategoryDAO.save(category);
			category = CategoryDAO.createCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
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
