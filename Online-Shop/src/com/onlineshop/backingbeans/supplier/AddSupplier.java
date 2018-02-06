package com.onlineshop.backingbeans.supplier;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onlineshop.dao.SupplierDAO;
import com.onlineshop.model.Supplier;

@SuppressWarnings("serial")
@ManagedBean(name="addSupplierBB")
@ViewScoped
public class AddSupplier implements Serializable{
	
	private Supplier supplier;
	
	public AddSupplier() {
		supplier = SupplierDAO.createSupplier();
	}
	
	public void extendEmails(){
		supplier.getEmail().add("");
	}
	
	public void extendPhones(){
		supplier.getPhone().add("");
	}
	

	
	public void saveSupplier() throws Exception {
		try {
			SupplierDAO.save(supplier);
			supplier = SupplierDAO.createSupplier();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
