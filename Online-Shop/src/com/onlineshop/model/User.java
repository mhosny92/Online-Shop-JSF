/**
 * 
 */
package com.onlineshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="shop_User")
public class User implements Serializable{

	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80A391610B1445FF0196B")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80A391610B1445FF0196B", strategy="native")	
	private int ID;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;
	
	@Column(name="City", nullable=true, length=255)	
	private String city;
	
	@Column(name="State", nullable=true, length=255)	
	private String state;
	
	@Column(name="Zip", nullable=false, length=10)	
	private int zip;
	
	@Column(name="EmailVerified", nullable=false)	
	private boolean emailVerified;
	
//	@Column(name="RegisteredOnDate", nullable=true)	
//	private java.util.Date registerationDate;
	
	@Column(name="VerificationCode", nullable=true, length=255)	
	private String verificationCode;
	
	@Column(name="Ip", nullable=true, length=255)	
	private String ip;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="Shop_User_phone", joinColumns={ @JoinColumn(name="UserID") })
	@OrderColumn(name="UserIndex")
	private List<String> phone = new ArrayList<String>();
	
	@Column(name="Country", nullable=true, length=255)	
	private String country;
	
	@Column(name="Address", nullable=true, length=255)	
	private String address;
	
	@Column(name="CountryCode", nullable=false, length=10)	
	private int countryCode;
	
	@SuppressWarnings("unused")
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setCity(String value) {
		this.city = value;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setState(String value) {
		this.state = value;
	}
	
	public String getState() {
		return state;
	}
	
	public void setZip(int value) {
		this.zip = value;
	}
	
	public int getZip() {
		return zip;
	}
	
	public void setEmailVerified(boolean value) {
		this.emailVerified = value;
	}
	
	public boolean getEmailVerified() {
		return emailVerified;
	}
	/*
	public void setRegisterationDate(java.util.Date value) {
		this.registerationDate = value;
	}
	
	public java.util.Date getRegisterationDate() {
		return registerationDate;
	}
	*/
	public void setVerificationCode(String value) {
		this.verificationCode = value;
	}
	
	public String getVerificationCode() {
		return verificationCode;
	}
	
	public void setIp(String value) {
		this.ip = value;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setPhone(List<String> value) {
		this.phone = value;
	}
	
	public List<String> getPhone() {
		return phone;
	}
	
	public void setCountry(String value) {
		this.country = value;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setCountryCode(int value) {
		this.countryCode = value;
	}
	
	public int getCountryCode() {
		return countryCode;
	}
}
