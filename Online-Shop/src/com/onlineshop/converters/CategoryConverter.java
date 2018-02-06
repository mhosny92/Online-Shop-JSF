package com.onlineshop.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.model.Category;

@FacesConverter("category")
public class CategoryConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		try {
			Category category = CategoryDAO.loadCategoryByID(Integer.parseInt(value));
			return category;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj == null || !(obj instanceof Category))
			return "";
		
		return Integer.toString(((Category)obj).getID());
	}

}
