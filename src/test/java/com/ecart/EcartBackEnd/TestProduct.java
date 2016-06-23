package com.ecart.EcartBackEnd;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.ProductDao;
import com.ecart.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		Product p1 = (Product) context.getBean("product");
		p1.setpId(10);
		p1.setpBrand("samsung");
		p1.setpModel("Z3 Tizen");
		p1.setpPrice(23000);
		p1.setpQty(12);
		
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		
		List<Product> pList = productDao.getProductList();
		Iterator<Product> i = pList.iterator();
		while(i.hasNext()){
			Product p = (Product) i.next();
			System.out.println(p.getpId());
			System.out.println(p.getpBrand());
		}
	}

}
