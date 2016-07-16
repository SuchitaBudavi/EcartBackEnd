package com.ecart.dao;

import java.util.List;

import com.ecart.model.CartDetails;

public interface CartDetailsDao {

	public List<CartDetails> getCart(String uId);
	
	public void saveOrUpdate(CartDetails cart);
	
	public void save(CartDetails cart);
	
	public void delete(CartDetails cart);
	
	public void delete(String uId, int pId, int cID);
}
