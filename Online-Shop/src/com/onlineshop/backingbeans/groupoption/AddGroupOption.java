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
import com.onlineshop.dao.OptionsGroupDAO;
import com.onlineshop.model.GroupOption;
import com.onlineshop.model.OptionsGroup;
import com.onlineshop.util.OnlineStore2Util;

/**
 * @author Mahmoud
 *
 */

@SuppressWarnings("serial")
@ManagedBean(name="addGroupOptionBB")
@ViewScoped
public class AddGroupOption implements Serializable{
	
	private GroupOption option;
	private List<OptionsGroup> optionsGroup;

	@PostConstruct
	public void init(){
		option = GroupOptionDAO.createOption();
		try{
			optionsGroup = (List<OptionsGroup>) OptionsGroupDAO.listOptionsGroups();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveOption() throws Exception{
		try{
			GroupOptionDAO.save(option);
			OnlineStore2Util.sucessMessage("msgs", "Option added");
			option = GroupOptionDAO.createOption();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the option
	 */
	public GroupOption getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(GroupOption option) {
		this.option = option;
	}

	/**
	 * @return the optionsGroup
	 */
	public List<OptionsGroup> getOptionsGroup() {
		return optionsGroup;
	}

	/**
	 * @param optionsGroup the optionsGroup to set
	 */
	public void setOptionsGroup(List<OptionsGroup> optionsGroup) {
		this.optionsGroup = optionsGroup;
	}
	
	

}
