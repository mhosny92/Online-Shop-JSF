package com.onlineshop.backingbeans.category;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.onlineshop.base.ViewImage;
import com.onlineshop.constants.Constants;
import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.model.Category;

@SuppressWarnings("serial")
@ManagedBean(name="viewCategoryImageBB")
@ApplicationScoped
public class ViewCategoryImage extends ViewImage implements Serializable{

	protected StreamedContent getImageContent(type t) throws Exception {	
		String path = Constants.UPLOAD_DIR;
		FacesContext context = FacesContext.getCurrentInstance();
		String cid = context.getExternalContext().getRequestParameterMap().get("cid");
		
		Category c = CategoryDAO.loadCategoryByID(Integer.parseInt(cid));
		String imageName = t==type.thumb? c.getThumb() : c.getImage();
		
		return new DefaultStreamedContent(new FileInputStream(new File(path	, imageName)));
	}
	
	
}
