package com.ecart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecart.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean validateUser(String email, String password) {
		String hql = "from User where email=" + email +" and password= "+ password;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> userList = query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return true;
		}
		return false;
	}

	@Transactional
	public User getUser(int uId) {
		String hql = "from User where uId=" + uId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> userList = query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	@Transactional
	public User getUser(String email) {
		String hql = "from User where email=" + email;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> userList = query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}
	
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
}
