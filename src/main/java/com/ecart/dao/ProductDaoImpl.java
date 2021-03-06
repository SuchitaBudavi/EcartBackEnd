package com.ecart.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecart.dao.ProductDao;
import com.ecart.model.Product;
import com.ecart.model.Supplier;

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

	@Override @Transactional
	public Product getProduct(int pId) {
		String hql = "from Product where pId=" + pId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> productList =  query.list();
		if(productList != null && !productList.isEmpty()){
			return productList.get(0);
		}
		return null;
	}

	@Override @Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);	
	}

	@Override @Transactional
	public void deleteProduct(int pId) {
		Product product = new Product();
		product = getProduct(pId);
		sessionFactory.getCurrentSession().delete(product);
	}

	@Override @Transactional
	public List<Product> getProductList(int cId) {
		String hql = "from Product where cId=" + cId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> productList =  query.list();
		if(productList != null && !productList.isEmpty()){
			return productList;
		}
		return null;
	}

	@Override @Transactional
	public Map<Integer, String> getProductNameList(int cId) {
		Map<Integer, String> nameListMap = new HashMap<Integer, String>();
		String hql = "select pId,pBrand from Product where cId=" + cId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List nameList = query.list();
		Iterator i = nameList.iterator();
		while (i.hasNext()) {
			Object[] result = (Object[]) i.next();
			nameListMap.put((Integer)result[0], (String)result[1]);
		}
		return nameListMap;
	}

	//get the list of distinct brands
	@Override @Transactional
	public List getBrands(int cId) {	
		String hql = "select distinct pBrand from Product where cId="+cId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List brandList = query.list();
		return brandList;
	}
	
}
