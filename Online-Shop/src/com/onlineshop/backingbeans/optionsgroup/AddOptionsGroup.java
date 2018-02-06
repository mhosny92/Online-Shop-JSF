package com.onlineshop.backingbeans.optionsgroup;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.OptionsGroupDAO;
import com.onlineshop.model.OptionsGroup;
import com.onlineshop.util.OnlineStore2Util;

@SuppressWarnings("serial")
@ManagedBean(name="addOptionsGroupBB")
@ViewScoped
public class AddOptionsGroup implements Serializable{
	private OptionsGroup optionsGroup;
	
	@PostConstruct
	public void init(){
		optionsGroup = OptionsGroupDAO.createOptionsGroup();
	}
	
	public void saveOptionsGroup() throws Exception{
		try{
			OptionsGroupDAO.save(optionsGroup);
			OnlineStore2Util.sucessMessage("msgs", "Options group added");
			optionsGroup = OptionsGroupDAO.createOptionsGroup();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return the optionsGroup
	 */
	public OptionsGroup getOptionsGroup() {
		return optionsGroup;
	}

	/**
	 * @param optionsGroup the optionsGroup to set
	 */
	public void setOptionsGroup(OptionsGroup optionsGroup) {
		this.optionsGroup = optionsGroup;
	}
	
}
