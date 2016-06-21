package com.ecart.dao;
import java.util.List;

import com.ecart.model.Product;

public interface ProductDao {

	//display list of products
	public List<Product> getProductList();
}
