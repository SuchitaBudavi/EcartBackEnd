package com.ecart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.model.MobileCoverFeature;
import com.ecart.model.MobileFeature;

@Repository("mobileCoverFeatureDao")
public class MobileCoverFeatureDaoImpl implements MobileCoverFeatureDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public MobileCoverFeatureDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override @Transactional
	public void saveOrUpdate(MobileCoverFeature mobileCoverFeature) {
		sessionFactory.getCurrentSession().saveOrUpdate(mobileCoverFeature);

	}

	@Override @Transactional
	public MobileCoverFeature getMobileCoverFeature(int pId, int cId) {
		String hql = "from MobileCoverFeature where pId="+pId+" and cId="+cId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<MobileCoverFeature> mobileCoverFeature = query.list();
		if(mobileCoverFeature != null && !mobileCoverFeature.isEmpty())
			return mobileCoverFeature.get(0);
		
		return null;
	}

	@Override @Transactional
	public void deleteMobileCoverFeature(int pId, int cId) {
		MobileCoverFeature mobileCoverFeature = getMobileCoverFeature(pId, cId);
		sessionFactory.getCurrentSession().delete(mobileCoverFeature);
	}

}
