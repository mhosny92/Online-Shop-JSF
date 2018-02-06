package com.onlineshop.backingbeans.product;

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
import com.onlineshop.dao.ProductDAO;
import com.onlineshop.model.Product;

@SuppressWarnings("serial")
@ManagedBean(name="viewProductImageBB")
@ApplicationScoped
public class ViewProductImage extends ViewImage implements Serializable {

	
	protected StreamedContent getImageContent(type t) throws Exception {
		String path = Constants.UPLOAD_DIR;
		FacesContext context = FacesContext.getCurrentInstance();
		String pid = context.getExternalContext().getRequestParameterMap().get("pid");
		
		Product p = ProductDAO.loadProductByID(Integer.parseInt(pid));
		String imageName = t==type.thumb? p.getThumb() : p.getImage();
		
		return new DefaultStreamedContent(new FileInputStream(new File(path	, imageName)));

	}

}
