package com.ecart.EcartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CategoryDao;
import com.ecart.dao.MobileFeatureDao;
import com.ecart.dao.ProductDao;
import com.ecart.model.Category;
import com.ecart.model.MobileFeature;
import com.ecart.model.ProductFeatureID;
import com.ecart.model.Product;

public class MoibilFeatureTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		Product p = (Product) context.getBean("product");
		ProductDao pDao = (ProductDao) context.getBean("productDao");
		
		Category c = (Category) context.getBean("category");
		CategoryDao cDao = (CategoryDao) context.getBean("categoryDao");
		
		MobileFeature mf = (MobileFeature) context.getBean("mobileFeature");
		MobileFeatureDao mfDao = (MobileFeatureDao) context.getBean("mobileFeatureDao");

		p = pDao.getProduct(1);
		c = p.getCategory_FK();
		ProductFeatureID mfId = new ProductFeatureID();
		mfId.setProduct_FK(p);
		mfId.setCategory_FK(c);
		
		mf.setMobileFeatureId(mfId);
		mf.setInternalMemory(32);
		mf.setRam(1);
		mf.setProcessor("1.3 GHz");
		mf.setOs("iOS v7");
		mf.setResolution("Retina Display, 1136 x 640 Pixels");
		mf.setScreenSize(4);
		mf.setFrontCam(8);
		mf.setRareCam(1.2);
		mf.setBattery(1560);
		mf.setBatteryDesc("Li-Ion, 1560 mAh");
		mf.setColor("Silver");
		
		mfDao.saveOrUpdate(mf);
	}

}
