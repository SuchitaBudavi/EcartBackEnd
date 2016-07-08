package com.ecart.dao;

import com.ecart.model.MobileFeature;

public interface MobileFeatureDao {

	public void saveOrUpdate(MobileFeature mobileFeature);
	
	public MobileFeature getMobileFeature(int pId, int cId);
	
	public void deleteMobileFeature(int pId, int cId);
}
