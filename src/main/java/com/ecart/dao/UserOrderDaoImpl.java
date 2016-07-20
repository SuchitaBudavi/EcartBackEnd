package com.ecart.dao;

import java.util.List;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.model.UserOrder;

@Repository("userOrderDao")
public class UserOrderDaoImpl implements UserOrderDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserOrderDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override @Transactional
	public void saveOrUpdare(UserOrder order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

	@Override @Transactional
	public List<UserOrder> getUserOrders(String uId) {
		String hql = "from UserOrder where uId='"+uId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserOrder> orderList = query.list();
		return orderList;
	}
}
