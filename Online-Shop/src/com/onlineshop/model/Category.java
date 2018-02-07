/**
 * 
 */
package com.onlineshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="shop_Category")
public class Category implements Serializable{
	/**
	 * Constructor for Category entity
	 */
	public Category() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80A391610B1445E201964")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80A391610B1445E201964", strategy="native")	
	private int ID;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="`Desc`", nullable=true, length=255)	
	private String desc;
	
	@Column(name="Thumb", nullable=true, length=255)	
	private String thumb;
	
	@Column(name="Image", nullable=true, length=255)	
	private String image;
	
	@Column(name="Active", nullable=false)	
	private boolean active;
	
	@OneToMany(mappedBy="category", targetEntity=Product.class)
	private List<Product> products = new ArrayList<Product>();
	
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
	
	public void setDesc(String value) {
		this.desc = value;
	}
	
	public String getDesc() {
		return desc;
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
	
	public void setActive(boolean value) {
		this.active = value;
	}
	
	public boolean getActive() {
		return active;
	}
	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (ID != other.ID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
