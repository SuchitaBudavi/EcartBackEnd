package com.ecart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecart.model.CartDetails;

@Repository("cartDetailsDao")
public class CartDetailsDaoImpl implements CartDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDetailsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override @Transactional
	public List<CartDetails> getCart(String uId) {
		String hql = "from CartDetails where uId="+uId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartDetails> cartList = query.list();
		if(cartList!=null && !cartList.isEmpty())
			return cartList;
		return null;
	}

	@Override @Transactional
	public void update(String uId, int pId, int cId, int sId, int qty) {
		String hql = "update CartDetails set qty="+qty+" where pId="+pId+" and cId="+cId+" and sId="+sId+" and uId='"+uId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override @Transactional
	public void save(CartDetails cart){
		sessionFactory.getCurrentSession().save(cart); 
	}
	
	@Override @Transactional
	public void delete(String uId, int pId, int cId, int sId) {
		String hql = "delete from CartDetails where pId="+pId+" and cId="+cId+" and sId="+sId+" and uId='"+uId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int result = query.executeUpdate();
	}
	
	
}
