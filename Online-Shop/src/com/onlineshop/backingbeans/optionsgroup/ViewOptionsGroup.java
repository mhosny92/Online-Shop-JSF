/**
 * 
 */
package com.onlineshop.backingbeans.optionsgroup;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.OptionsGroupDAO;
import com.onlineshop.model.OptionsGroup;

/**
 * @author Mahmoud
 *
 */

@SuppressWarnings("serial")
@ManagedBean(name="viewOptionsGroupBB")
@ViewScoped
public class ViewOptionsGroup implements Serializable{
	
	private List<OptionsGroup> optionsGroups;
	
	@PostConstruct
	public void init(){
		try{
			optionsGroups = (List<OptionsGroup>)OptionsGroupDAO.listOptionsGroups();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return the optionsGroups
	 */
	public List<OptionsGroup> getOptionsGroups() {
		return optionsGroups;
	}

	/**
	 * @param optionsGroups the optionsGroups to set
	 */
	public void setOptionsGroups(List<OptionsGroup> optionsGroups) {
		this.optionsGroups = optionsGroups;
	}

}
