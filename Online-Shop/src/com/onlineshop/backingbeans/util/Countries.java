/**
 * 
 */
package com.onlineshop.backingbeans.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@ManagedBean(name="countriesBB")
@ApplicationScoped
public class Countries implements Serializable{
	
	private List<String> names = new ArrayList<String>();
	
	public Countries(){
		String[] locales = Locale.getISOCountries();
		for (String loc:locales){
			Locale l = new Locale("",loc);
			names.add(l.getDisplayCountry());
		}
	}
	
	public List<String> getNames(){
		return names;
	}

}
