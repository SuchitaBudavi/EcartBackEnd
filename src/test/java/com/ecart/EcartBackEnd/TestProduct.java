package com.ecart.EcartBackEnd;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CategoryDao;
import com.ecart.dao.ProductDao;
import com.ecart.dao.SupplierDao;
import com.ecart.dao.UserDao;
import com.ecart.model.Address;
import com.ecart.model.Category;
import com.ecart.model.Product;
import com.ecart.model.Supplier;
import com.ecart.model.User;

public class TestProduct {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		Product p = (Product) context.getBean("product");
		ProductDao pDao = (ProductDao) context.getBean("productDao");
		
		Category c = (Category) context.getBean("category");
		CategoryDao cDao = (CategoryDao) context.getBean("categoryDao");
		
		Supplier s = (Supplier) context.getBean("supplier");
		SupplierDao sDao = (SupplierDao) context.getBean("supplierDao");
		
		p.setpBrand("samsung");
		p.setpModel("6S");
		p.setpDesc("color mobile");
		p.setpPrice(50000);
		p.setpQty(8);
		
		c = cDao.getCategory(2);
		s = sDao.getSuuplier(3);
		
		p.setsId(s);
		//c.getProduct().add(p);
		p.setcId(c);
		
		pDao.saveOrUpdate(p);
		
		/*Category c = (Category) context.getBean("category");
		CategoryDao cDao = (CategoryDao) context.getBean("categoryDao");
		c.setcId(2);
		c.setcName("Mobile Covers!!!!");
		
		cDao.saveOrUpdate(c);
		
		cDao.deleteCategory(1);
		
		List<Category> sList = cDao.getCategoryList();
		Iterator<Category> i = sList.iterator();
		while(i.hasNext()){
			Category s = (Category) i.next();
			System.out.println(s.getcId()+" "+s.getcName());
		}*/
		
		/*cDao.saveOrUpdate(c);
		
		System.out.println(cDao.getCategory(1).getcName());*/
		
		/*Supplier s = (Supplier) context.getBean("supplier");
		SupplierDao sDao = (SupplierDao) context.getBean("supplierDao");*/
		
		/*s.setsId(1);
		s.setsName("NIIT2");
		
		Address addr = new Address();
		addr.setStreet("cafe good luck2");
		addr.setCity("pune2");
		addr.setState("MH2");
		addr.setPincode(411001);
		
		s.setAddress(addr);
		
		sDao.saveOrUpdate(s);
		*/
		/*List<Supplier> sList = sDao.getSupplierList();
		Iterator<Supplier> i = sList.iterator();
		while(i.hasNext()){
			s = (Supplier) i.next();
			System.out.println(s.getsId()+" "+s.getAddress().getState());
		}*/
		
		//sDao.deleteSupplier(1);
		
		/*Product p1 = (Product) context.getBean("product");
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
			System.out.println(p.getpId()+"added");
			System.out.println(p.getpBrand());
		}
		*/
		
		/*UserDao userDao = (UserDao) context.getBean("userDao");
		User user = (User) context.getBean("user");*/
		
		/*user.setfName("suchita");
		user.setlName("budavi");
		user.setEmail("suchi@gmail.com");
		user.setPassword("suchi");
		
		userDao.saveOrUpdate(user);
		*/
		//System.out.println(userDao.getUser(1).getlName());
		
		//System.out.println(userDao.validateUser("rohitgmail", "rohit"));
		
	}

}
