/**
 * 
 */
package com.onlineshop.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.onlineshop.dao.OptionsGroupDAO;
import com.onlineshop.model.OptionsGroup;

/**
 * @author Mahmoud
 *
 */
@FacesConverter("optionsGroup")
public class OptionsGroupConverter implements Converter{

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		try {
			OptionsGroup optionsGroup = OptionsGroupDAO.loadOptionsGroupByID(Integer.parseInt(value));
			return optionsGroup;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj == null || !(obj instanceof OptionsGroup))
			return "";
		
		return Integer.toString(((OptionsGroup)obj).getID());
	}

}
