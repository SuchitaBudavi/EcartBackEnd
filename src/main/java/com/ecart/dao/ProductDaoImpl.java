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
		
		/*Product p1 = new Product();
		
		p1.setpId(1);
		p1.setpBrand("iphone");
		p1.setpModel("6S");
		p1.setpPrice(45000);
		p1.setpQty(3);
		
		Product p2 = new Product();
		
		p2.setpId(2);
		p2.setpBrand("samsung");
		p2.setpModel("7J");
		p2.setpPrice(25000);
		p2.setpQty(6);
		
		List<Product> pList = new ArrayList<Product>();
		pList.add(p1);
		pList.add(p2);*/
		return pList;
	}

}
