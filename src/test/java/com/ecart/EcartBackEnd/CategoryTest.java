package com.ecart.EcartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CategoryDao;
import com.ecart.model.Category;

public class CategoryTest {

	public static void main(String[] arg){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		Category c = (Category) context.getBean("category");
		CategoryDao cDao = (CategoryDao) context.getBean("categoryDao");
		
		c.setcName("");
		cDao.saveOrUpdate(c);
	}
}
