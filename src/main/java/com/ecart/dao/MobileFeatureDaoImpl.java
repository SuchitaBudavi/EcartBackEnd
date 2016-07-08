package com.ecart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.model.MobileFeature;

@Repository("mobileFeatureDao")
public class MobileFeatureDaoImpl implements MobileFeatureDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public MobileFeatureDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override @Transactional
	public void saveOrUpdate(MobileFeature mobileFeature) {
		sessionFactory.getCurrentSession().saveOrUpdate(mobileFeature);
	}


	@Override @Transactional
	public MobileFeature getMobileFeature(int pId, int cId) {
		String hql = "from MobileFeature where pId="+pId+" and cId="+cId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<MobileFeature> mobileFeature = query.list();
		if(mobileFeature != null && !mobileFeature.isEmpty())
			return mobileFeature.get(0);
		
		return null;
	}
	
	@Override @Transactional
	public void deleteMobileFeature(int pId, int cId) {
		MobileFeature mobileFeature = getMobileFeature(pId, cId);
		sessionFactory.getCurrentSession().delete(mobileFeature);
	}
}
