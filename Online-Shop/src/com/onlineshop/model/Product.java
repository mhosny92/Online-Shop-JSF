/**
 * 
 */
package com.onlineshop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="shop_Product")
public class Product implements Serializable{
	/**
	 * Constructor for product
	 */
	public Product() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80A391610B1445F001966")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80A391610B1445F001966", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=Category.class)
	@JoinColumns({ @JoinColumn(name="CategoryID", referencedColumnName="ID") })
	@Basic(fetch=FetchType.LAZY)
	private Category category;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="SKU", nullable=true, length=255)	
	private String SKU;
	
	@Column(name="Price", nullable=false, length=10)	
	private double price;
	
	@Column(name="Weight", nullable=false, length=10)	
	private double weight;
	
	@Column(name="CartDesc", nullable=true, length=255)	
	private String cartDesc;
	
	@Column(name="ShortDesc", nullable=true, length=255)	
	private String shortDesc;
	
	@Column(name="LongDesc", nullable=true, length=255)	
	private String longDesc;
	
	@Column(name="Thumb", nullable=true, length=255)	
	private String thumb;
	
	@Column(name="Image", nullable=true, length=255)	
	private String image;
	
	@Column(name="UpdateDate", nullable=true)	
	private java.util.Date updateDate;
	
	@Column(name="Stock", nullable=false, length=10)	
	private int stock;
	
	@Column(name="Active", nullable=false)	
	private boolean active;

	
	@ManyToMany(mappedBy="product", targetEntity=Supplier.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Supplier> supplier = new HashSet<Supplier>();
	
	@ManyToMany(targetEntity=GroupOption.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="shop_Product_Option", joinColumns={ @JoinColumn(name="ProductID") }, inverseJoinColumns={ @JoinColumn(name="OptionID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<GroupOption> option = new HashSet<GroupOption>();

	
	
	
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
	
	public void setSKU(String value) {
		this.SKU = value;
	}
	
	public String getSKU() {
		return SKU;
	}
	
	public void setPrice(double value) {
		this.price = value;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setWeight(double value) {
		this.weight = value;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setCartDesc(String value) {
		this.cartDesc = value;
	}
	
	public String getCartDesc() {
		return cartDesc;
	}
	
	public void setShortDesc(String value) {
		this.shortDesc = value;
	}
	
	public String getShortDesc() {
		return shortDesc;
	}
	
	public void setLongDesc(String value) {
		this.longDesc = value;
	}
	
	public String getLongDesc() {
		return longDesc;
	}
	
	public void setThumb(String value) {
		this.thumb = value;
	}
	
	public String getThumb() {
		return thumb;
	}
	
	public void setImage(String value) {
		this.image = value;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setUpdateDate(java.util.Date value) {
		this.updateDate = value;
	}
	
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	
	public void setStock(int value) {
		this.stock = value;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setActive(boolean value) {
		this.active = value;
	}
	
	public boolean getActive() {
		return active;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the supplier
	 */
	public Set<Supplier> getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Set<Supplier> supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the option
	 */
	public Set<GroupOption> getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(Set<GroupOption> option) {
		this.option = option;
	}

}
