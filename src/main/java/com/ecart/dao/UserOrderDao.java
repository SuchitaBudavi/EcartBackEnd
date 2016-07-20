package com.ecart.dao;

import java.util.List;

import com.ecart.model.UserOrder;

public interface UserOrderDao {

	public void saveOrUpdare(UserOrder order);
	
	public List<UserOrder> getUserOrders(String uId); 
}
