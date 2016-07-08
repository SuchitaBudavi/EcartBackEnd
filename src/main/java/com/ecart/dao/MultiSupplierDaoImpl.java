package com.ecart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.model.MultiSupplier;

@Repository("multiSupplierDao")
public class MultiSupplierDaoImpl implements MultiSupplierDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public MultiSupplierDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override @Transactional
	public List<MultiSupplier> getProductSuppliersList(int pId) {
		String hql = "from MultiSupplier where pId="+pId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<MultiSupplier> productSuppliersList = query.list();
		return productSuppliersList;
	}

	
	
	@Override
	public MultiSupplier getProductSupplier(int pId, int cId, int sId) {
		String hql = "from MultiSupplier where pId="+pId+" and cId="+cId+" and sId="+sId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<MultiSupplier> productSuppliersList = query.list();
		if (productSuppliersList != null && !productSuppliersList.isEmpty()) {
			return productSuppliersList.get(0);
		}
		return null;
	}


	@Override @Transactional
	public void saveOrUpdate(MultiSupplier productSupplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(productSupplier);
	}

	@Override @Transactional
	public void deleteProductSupplier(int pId, int cId, int sId) {
		MultiSupplier productSupplier = getProductSupplier(pId, cId, sId);
		sessionFactory.getCurrentSession().delete(productSupplier);
	}


	@Override @Transactional
	public void updatePriceQty(int pId, int cId, int sId, int price, int qty) {
		Query query = sessionFactory.getCurrentSession().createQuery("update MultiSupplier set pPrice=:price, pQty=:qty where pId="+pId+" and cId="+cId+" and sId="+sId);
		query.setParameter("price", price);
		query.setParameter("qty", qty);
		
		query.executeUpdate();
	}

	
}
