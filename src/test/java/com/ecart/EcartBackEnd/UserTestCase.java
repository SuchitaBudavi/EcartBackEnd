package com.ecart.EcartBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.UserDao;
import com.ecart.model.User;

public class UserTestCase {

	static UserDao uDao;
	
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		uDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void validateUser() {
		assertEquals("User test: validate Admin true", new Integer(1), uDao.validateUser("suchigmail", "suchi"));
		assertEquals("User test: validate User true", new Integer(1), uDao.validateUser("sweetygmail", "sweety"));
	}
	
	@Test
	public void getUserTest(){
		User u = uDao.getUser(5);
		if(u == null)
			u = new User();
		//test of first name
		assertEquals("User test: get user true","suchita",u.getfName());
	}
}
