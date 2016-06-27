package com.ecart.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecart.dao.ProductDao;
import com.ecart.model.Product; 
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Product> getProductList() {
		
		List<Product> pList;
		 pList = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		
		return pList;
	}

}
