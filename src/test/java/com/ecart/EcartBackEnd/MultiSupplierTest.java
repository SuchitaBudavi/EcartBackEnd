package com.ecart.EcartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CategoryDao;
import com.ecart.dao.MultiSupplierDao;
import com.ecart.dao.ProductDao;
import com.ecart.dao.SupplierDao;
import com.ecart.model.Category;
import com.ecart.model.MultiSupplier;
import com.ecart.model.MultiSupplierID;
import com.ecart.model.Product;
import com.ecart.model.Supplier;

public class MultiSupplierTest {

	public static void main(String[] arg){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		MultiSupplier ms = (MultiSupplier) context.getBean("multiSupplier");
		MultiSupplierDao msDao = (MultiSupplierDao) context.getBean("multiSupplierDao");
		
		Product p = (Product) context.getBean("product");
		ProductDao pDao = (ProductDao) context.getBean("productDao");
		
		Category c = (Category) context.getBean("category");
		CategoryDao cDao = (CategoryDao) context.getBean("categoryDao");
		
		Supplier s = (Supplier) context.getBean("supplier");
		SupplierDao sDao = (SupplierDao) context.getBean("supplierDao");
		
		/*p = pDao.getProduct(5);
		System.out.println(p.getpModel()+"model");
		c = p.getCategory_FK();
		s = p.getSupplier_FK();
		System.out.println(c.getcName()+s.getsName());
		
		ms.setpPrice(48000);
		ms.setpQty(3);
		System.out.println(ms.getpPrice()+" "+ms.getpQty());
		
		MultiSupplierID msId = new MultiSupplierID();
		
		msId.setProduct_FK(p);
		msId.setCategory_FK(c);
		msId.setSupplier_FK(s);
		ms.setMultiSupplierId(msId);
		
		msDao.saveOrUpdate(ms);*/
		
		msDao.updatePriceQty(5, 2, 3, 1000, 50);
	}
}
