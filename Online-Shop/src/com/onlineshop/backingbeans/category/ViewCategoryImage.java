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

@SuppressWarnings("serial")
@ManagedBean(name="viewCategoryImage")
@ApplicationScoped
public class ViewCategoryImage extends ViewImage implements Serializable{

	protected StreamedContent getImageContent() throws Exception {	
		String path = Constants.UPLOAD_DIR;
		FacesContext context = FacesContext.getCurrentInstance();
		String imageName = context.getExternalContext().getRequestParameterMap().get("imageName");
		return new DefaultStreamedContent(new FileInputStream(new File(path	, imageName)));
	}
	
	
}
