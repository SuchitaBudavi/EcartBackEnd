package com.ecart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecart.model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override @Transactional
	public List<Supplier> getSupplierList() {
		return sessionFactory.getCurrentSession().createCriteria(Supplier.class).list();
	}

	@Override @Transactional
	public Supplier getSuuplier(int sId) {
		String hql = "from Supplier where sId=" + sId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> supplierList =  query.list();
		if(supplierList != null && !supplierList.isEmpty()){
			return supplierList.get(0);
		}
		return null;
	}

	@Override @Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

	@Override @Transactional
	public void deleteSupplier(int sId) {
		Supplier supplier = new Supplier();
		supplier = getSuuplier(sId);
		sessionFactory.getCurrentSession().delete(supplier);
	}

}
