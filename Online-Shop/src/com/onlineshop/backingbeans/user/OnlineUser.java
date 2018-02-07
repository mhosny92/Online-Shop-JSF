/**
 * 
 */
package com.onlineshop.backingbeans.user;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.onlineshop.dao.UserDAO;
import com.onlineshop.model.User;

/**
 * @author Mahmoud
 *
 */

@SuppressWarnings("serial")
@ManagedBean(name="onlineUser")
@SessionScoped
public class OnlineUser implements Serializable{
	
	private User user;
	private String name, pswd;
	
	
	
	/**
	 * Constructor for online user backing bean
	 */
	public OnlineUser() {
	}
	
	
	public String login(){
		user = UserDAO.validUser(name, pswd);
		if (user != null){
			return "index.xhtml"; 
		}else {
			FacesMessage msg = new FacesMessage("invalid username or password");
			FacesContext.getCurrentInstance().addMessage("error_msg", msg);
			return "";
		}
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pswd
	 */
	public String getPswd() {
		return pswd;
	}

	/**
	 * @param pswd the pswd to set
	 */
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	
	

}
