/**
 * 
 */
package com.onlineshop.backingbeans.user;

import java.io.Serializable;
import java.util.List;

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
@ManagedBean(name="viewUserBB")
@ViewScoped
public class ViewUser implements Serializable{
	private List<User> users;
	
	
	@PostConstruct
	public void init(){
		users = (List<User>)UserDAO.listUsers();
	}
	/**
	 * 
	 */
	public ViewUser() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
