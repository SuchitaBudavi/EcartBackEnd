package com.ecart.dao;

import java.util.List;

import com.ecart.model.Supplier;

public interface SupplierDao {

	public List<Supplier> getSupplierList();
	
	public Supplier getSuuplier(int sId);
	
	public void saveOrUpdate(Supplier supplier);
	
	public void deleteSupplier(int sId);
	
}
