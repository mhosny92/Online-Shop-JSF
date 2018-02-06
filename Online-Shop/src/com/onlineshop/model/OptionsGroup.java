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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Mahmoud
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="shop_OptionsGroup")
public class OptionsGroup implements Serializable{
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="VC0A80A391610B1445F301967")	
	@org.hibernate.annotations.GenericGenerator(name="VC0A80A391610B1445F301967", strategy="native")	
	private int ID;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@OneToMany(mappedBy="optionsGroup", targetEntity=GroupOption.class)
	private Set<GroupOption> option = new HashSet<GroupOption>();
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionsGroup other = (OptionsGroup) obj;
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
