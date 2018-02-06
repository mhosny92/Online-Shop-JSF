package com.onlineshop.backingbeans.supplier;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.SupplierDAO;
import com.onlineshop.model.Supplier;


@SuppressWarnings("serial")
@ManagedBean(name="viewSupplierBB")
@ViewScoped
public class ViewSupplier implements Serializable{
	private List<Supplier> suppliers;
	
	@PostConstruct
	public void init() {
		try{
			suppliers = (List<Supplier>)SupplierDAO.listSuppliers();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ViewSupplier() {	}

	/**
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	/**
	 * @param suppliers the suppliers to set
	 */
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	

}
