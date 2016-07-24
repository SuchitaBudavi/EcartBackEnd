package com.ecart.EcartBackEnd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.UserDao;
import com.ecart.model.Address;
import com.ecart.model.User;

public class TestUser {

	public static void main(String[] arg){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		User u = (User) context.getBean("user");
		UserDao uDao = (UserDao) context.getBean("userDao");
		//uDao.enableUser(1, false);
		u.setfName("suchita");
		u.setlName("b");
		u.setEmail("suchigmail");
		u.setPassword("suchi");
		u.setContactNum(76554);
		u.setIsAdmin(1);
		
		Address a1 = new Address();
		a1.setStreet("road 8");
		a1.setCity("pune");
		a1.setState("MH");
		a1.setPincode(411044);
		List<Address> addrList = new ArrayList<Address>();
		addrList.add(a1);
		
		Address a2 = new Address();
		a2.setStreet("road 10");
		a2.setCity("pune");
		a2.setState("MH");
		a2.setPincode(411040);
		addrList.add(a2);
		
		u.setAddressList(addrList);
		uDao.save(u);
		
		
	}
}
