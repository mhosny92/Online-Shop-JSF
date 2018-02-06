/**
 * 
 */
package com.onlineshop.backingbeans.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.UserDAO;
import com.onlineshop.model.User;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@ManagedBean(name="addUserBB")
@ViewScoped
public class AddUser implements Serializable{
	
	private User user;
	
	@PostConstruct
	public void init(){
		user = UserDAO.createUser();
	}
	
	public void extendPhones(){
		user.getPhone().add("");
	}
	
	/**
	 * Constructor for AddUser backing bean
	 */
	public AddUser() {
	}
	
	public void saveUser(){
		try{
			UserDAO.save(user);
			user = UserDAO.createUser();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
