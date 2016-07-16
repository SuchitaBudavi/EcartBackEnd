package com.ecart.EcartBackEnd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CartDetailsDao;
import com.ecart.dao.CategoryDao;
import com.ecart.dao.ProductDao;
import com.ecart.dao.SupplierDao;
import com.ecart.dao.UserDao;
import com.ecart.model.CartDetails;
import com.ecart.model.Category;
import com.ecart.model.GuestCartDetails;
import com.ecart.model.Product;
import com.ecart.model.Supplier;
import com.ecart.model.User;

public class CartTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		
		CartDetailsDao cdDao = (CartDetailsDao) context.getBean("cartDetailsDao");
		
		Product p = (Product) context.getBean("product");
		ProductDao pDao = (ProductDao) context.getBean("productDao");
		
		
		UserDao uDao = (UserDao) context.getBean("userDao");
		User u = (User)context.getBean("user");
		
		/*CartDetails cartDetails = new CartDetails();
		u = uDao.getUser(3);
		cartDetails.setUser_FK(u);
		p = pDao.getProduct(2);
		cartDetails.setProduct_FK(p);
		cartDetails.setCategory_FK(p.getCategory_FK());
		cartDetails.setSupplier_FK(p.getSupplier_FK());
		cartDetails.setPrice(p.getpPrice());
		cartDetails.setQty(1);
		List<CartDetails> cartList = new ArrayList<CartDetails>();
		
		CartDetails cartDetails2 = new CartDetails();
		u = uDao.getUser(3);
		cartDetails2.setUser_FK(u);
		p = pDao.getProduct(3);
		cartDetails2.setProduct_FK(p);
		cartDetails2.setCategory_FK(p.getCategory_FK());
		cartDetails2.setSupplier_FK(p.getSupplier_FK());
		cartDetails2.setPrice(p.getpPrice());
		cartDetails2.setQty(2);
		
		cartList.add(cartDetails);
		cartList.add(cartDetails2);
		
		u.setuCart(cartList);
		cdDao.saveOrUpdate(cartDetails);
		cdDao.saveOrUpdate(cartDetails2);
		uDao.saveOrUpdate(u);
		//cart.setCartDetails(cartList);
		//cart.setUser_FK(u);
		
		System.out.println("before save");
		uDao.saveOrUpdate(u);
*/
		cdDao.delete("3", 11, 1);
	}
}
