/**
 * 
 */
package com.onlineshop.model;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="shop_Order")
public class Order implements Serializable{
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80A391610B1445FC0196A")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80A391610B1445FC0196A", strategy="native")	
	private int ID;
	
	@Column(name="Amount", nullable=false, length=10)	
	private int amount;
	
	@Column(name="ShipName", nullable=true, length=255)	
	private String shipName;
	
	@Column(name="ShipAddress", nullable=true, length=255)	
	private String shipAddress;
	
	@Column(name="City", nullable=true, length=255)	
	private String city;
	
	@Column(name="State", nullable=true, length=255)	
	private String state;
	
	@Column(name="Zip", nullable=false, length=10)	
	private int zip;
	
	@Column(name="Country", nullable=true, length=255)	
	private String country;
	
	@Column(name="CountryCode", nullable=false, length=10)	
	private int countryCode;
	
	@Column(name="Phone", nullable=true, length=255)	
	private String phone;
	
	@Column(name="ShippingCost", nullable=false, length=10)	
	private double shippingCost;
	
	@Column(name="TaxCost", nullable=false, length=10)	
	private double taxCost;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="`Date`", nullable=true)	
	private java.util.Date date;
	
	@Column(name="Shipped", nullable=false)	
	private boolean shipped;
	
	@Column(name="Tracking", nullable=true, length=255)	
	private String tracking;
	
	@Column(name="Details", nullable=true, length=255)	
	private String details;
	
	@SuppressWarnings("unused")
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}

	public void setAmount(int value) {
		this.amount = value;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setShipName(String value) {
		this.shipName = value;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public void setShipAddress(String value) {
		this.shipAddress = value;
	}
	
	public String getShipAddress() {
		return shipAddress;
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
	
	public void setCountry(String value) {
		this.country = value;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountryCode(int value) {
		this.countryCode = value;
	}
	
	public int getCountryCode() {
		return countryCode;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setShippingCost(double value) {
		this.shippingCost = value;
	}
	
	public double getShippingCost() {
		return shippingCost;
	}
	
	public void setTaxCost(double value) {
		this.taxCost = value;
	}
	
	public double getTaxCost() {
		return taxCost;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setShipped(boolean value) {
		this.shipped = value;
	}
	
	public boolean getShipped() {
		return shipped;
	}
	
	public void setTracking(String value) {
		this.tracking = value;
	}
	
	public String getTracking() {
		return tracking;
	}
	
	public void setDetails(String value) {
		this.details = value;
	}
	
	public String getDetails() {
		return details;
	}
}
