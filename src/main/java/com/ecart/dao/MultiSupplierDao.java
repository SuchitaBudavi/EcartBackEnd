package com.ecart.dao;

import java.util.List;

import com.ecart.model.MultiSupplier;
import com.ecart.model.Product;

public interface MultiSupplierDao {
	
	public List<MultiSupplier> getProductSuppliersList(int pId);
	
	public MultiSupplier getProductSupplier(int pId, int cId, int sId);
	
	public void saveOrUpdate(MultiSupplier productSupplier);
	
	public void deleteProductSupplier(int pId, int cId, int sId);
	
	public void updatePriceQty(int pId, int cId, int sId, int price, int qty);
}
