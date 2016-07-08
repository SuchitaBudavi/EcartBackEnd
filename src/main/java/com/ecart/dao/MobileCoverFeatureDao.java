package com.ecart.dao;

import com.ecart.model.MobileCoverFeature;

public interface MobileCoverFeatureDao {
	
	public void saveOrUpdate(MobileCoverFeature mobileCoverFeature);
	
	public MobileCoverFeature getMobileCoverFeature(int pId, int cId);
	
	public void deleteMobileCoverFeature(int pId, int cId);
}
