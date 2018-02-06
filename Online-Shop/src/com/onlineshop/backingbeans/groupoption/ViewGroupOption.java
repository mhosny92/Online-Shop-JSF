/**
 * 
 */
package com.onlineshop.backingbeans.groupoption;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.GroupOptionDAO;
import com.onlineshop.model.GroupOption;


/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@ManagedBean(name="viewGroupOptionBB")
@ViewScoped
public class ViewGroupOption implements Serializable{
	
	private List<GroupOption> options;
	
	@PostConstruct
	public void init(){
		try{
			options = (List<GroupOption>)GroupOptionDAO.listOptions();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return the options
	 */
	public List<GroupOption> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(List<GroupOption> options) {
		this.options = options;
	}

}
