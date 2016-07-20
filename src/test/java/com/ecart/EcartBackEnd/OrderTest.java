package com.ecart.EcartBackEnd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CartDetailsDao;
import com.ecart.dao.UserOrderDao;
import com.ecart.dao.UserDao;
import com.ecart.model.Address;
import com.ecart.model.CartDetails;
import com.ecart.model.UserOrder;
import com.ecart.model.User;

public class OrderTest {

	public enum paymentMode {
	    UNPAID, NET, CREDIT, DEBIT, COD 
	}
	
	public static void main(String[] arg0){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		UserOrderDao oDao = (UserOrderDao) context.getBean("userOrderDao");
		UserOrder o = (UserOrder) context.getBean("userOrder");
		
		UserDao uDao = (UserDao) context.getBean("userDao");
		User u = (User) context.getBean("user");
		
		CartDetailsDao cdDao = (CartDetailsDao) context.getBean("cartDetailsDao");
		CartDetails cd = (CartDetails) context.getBean("cartDetails");
	
		
		/*u = uDao.getUser(3);
		o.setUser(u);
		
		List<CartDetails> cartList = cdDao.getCart("3");
		
		o.setCartList(cartList);
		System.out.println(o.getCartList().get(0).getPrice());
		Address addr = (Address) context.getBean("address");
		addr.setCity("nashik");
		addr.setPincode(12345);
		addr.setState("MH");
		addr.setStreet("route 7");
		o.setShippingAdr(addr);
		o.setTotal(2000);
		o.setPaymentMode(com.ecart.model.PaymentMode.paymentMode.UNPAID);
		oDao.saveOrUpdare(o);*/
		List<UserOrder> orderList = oDao.getUserOrders("3");
		Iterator i = orderList.iterator();
		while(i.hasNext()){
			UserOrder orderItem = (UserOrder) i.next();
			System.out.println("Total order amount: "+orderItem.getTotal());
			System.out.println("first item amount: "+orderItem.getCartList().get(0).getPrice());
			System.out.println("second item amount: "+orderItem.getCartList().get(1).getPrice());
		}
	}
}

