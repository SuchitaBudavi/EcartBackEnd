package com.ecart.EcartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CategoryDao;
import com.ecart.dao.MobileCoverFeatureDao;
import com.ecart.dao.ProductDao;
import com.ecart.model.Category;
import com.ecart.model.MobileCoverFeature;
import com.ecart.model.Product;
import com.ecart.model.ProductFeatureID;

public class MobileCoverFeatureTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		Product p = (Product) context.getBean("product");
		ProductDao pDao = (ProductDao) context.getBean("productDao");
		
		Category c = (Category) context.getBean("category");
		CategoryDao cDao = (CategoryDao) context.getBean("categoryDao");
		
		MobileCoverFeature mcf = (MobileCoverFeature) context.getBean("mobileCoverFeature");
		MobileCoverFeatureDao mcfDao = (MobileCoverFeatureDao) context.getBean("mobileCoverFeatureDao");

		p = pDao.getProduct(5);
		c = p.getCategory_FK();
		ProductFeatureID mfId = new ProductFeatureID();
		mfId.setProduct_FK(p);
		mfId.setCategory_FK(c);
		
		mcf.setMobileCoverFeatureId(mfId);
		mcf.setPlainOrDesigned("Plain");
		mcf.setCaseType("body cover");
		mcf.setColor("red");
		mcf.setMaterial("plastic");
		mcf.setMobileBrand("iPhone");
		mcf.setMobileModel("5S");
		mcfDao.saveOrUpdate(mcf);
	}
}
