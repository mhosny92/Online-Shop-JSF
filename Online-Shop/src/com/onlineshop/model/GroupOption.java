/**
 * 
 */
package com.onlineshop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="shop_GroupOption")
public class GroupOption implements Serializable{
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80A391610B1445F601968")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80A391610B1445F601968", strategy="native")	
	private int ID;
	
	@Column(name="Name", nullable=false, length=255)	
	private String name;
	
	
	@ManyToOne(targetEntity=OptionsGroup.class)
	@JoinColumns({ @JoinColumn(name="OptionsGroupID", referencedColumnName="ID") })
	private OptionsGroup optionsGroup;
	
	@ManyToMany(mappedBy="option", targetEntity=Product.class)
	private Set<Product> product = new HashSet<Product>();
	
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
