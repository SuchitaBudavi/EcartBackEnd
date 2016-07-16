package com.ecart.dao;

import com.ecart.model.CartDetails;

public interface CartDetailsDao {

	public CartDetails getCart(int uId);
	
	public void saveOrUpdate(CartDetails cart);
	
	public void delete(CartDetails cart);
}
