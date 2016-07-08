package com.ecart.dao;
import java.util.List;

import com.ecart.model.Product;


public interface ProductDao {

	public List<Product> getProductList();
	
	public List<Product> getProductList(int cId);
	
	public Product getProduct(int pId);
	
	public void saveOrUpdate(Product product);
	
	public void deleteProduct(int pId);
	
}
