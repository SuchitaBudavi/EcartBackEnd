package com.ecart.dao;

import java.util.List;

import com.ecart.model.CartDetails;

public interface CartDetailsDao {

	public List<CartDetails> getCart(String uId);
	
	public void update(String uId, int pId, int cId, int sId, int qty);
	
	public void save(CartDetails cart);
	
	public void delete(String uId, int pId, int cId, int sId);
}
