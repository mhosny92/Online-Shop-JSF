/**
 * 
 */
package com.onlineshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="shop_Supplier")
public class Supplier implements Serializable {
	
	/**
	 * Constructor for supplier
	 */
	public Supplier() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80A391610B1445EC01965")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80A391610B1445EC01965", strategy="native")	
	private int ID;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="Country", nullable=true, length=255)	
	private String country;
	
	@Column(name="Address", nullable=true, length=255)	
	private String address;
	
	@Column(name="CountryCode", nullable=false, length=10)	
	private int countryCode;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="Shop_Supplier_phone", joinColumns={ @JoinColumn(name="SupplierID") })
	@OrderColumn(name="SupplierIndex")
	private List<String> phone = new ArrayList<String>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="Shop_Supplier_email", joinColumns={ @JoinColumn(name="SupplierID") })
	@OrderColumn(name="SupplierIndex")
	private List<String> email = new ArrayList<String>();
	
	@ManyToMany(targetEntity=Product.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Shop_Supplier_Product", joinColumns={ @JoinColumn(name="SupplierID") }, inverseJoinColumns={ @JoinColumn(name="ProductID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Product> product = new HashSet<Product>();
	
	
	@SuppressWarnings("unused")
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
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
	public List<String> getPhone() {
		return this.phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	public List<String> getEmail() {
		return this.email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	/**
	 * @return the product
	 */
	public Set<Product> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
