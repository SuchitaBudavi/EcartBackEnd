package com.ecart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	public Integer validateUser(String email, String password) {
	/*	String hql = "from User where email=" +"'" + email + "'" +" and password= "+ "'" +password + "'";
		System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> userList = query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return true;
		}
		return false;*/
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.setProjection(Projections.property("isAdmin"));
	
		Criterion emailRes = Restrictions.eq("email",email);
		Criterion passwordRes = Restrictions.eq("password",password);
		
		LogicalExpression andExp = Restrictions.and(emailRes, passwordRes);
		
		criteria.add(andExp);
		
		List userList = criteria.list();
		if (userList != null && !userList.isEmpty()) {
			System.out.println(userList.get(0));
			return (Integer) userList.get(0);
		}
		
		return -1;
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
		String hql = "from User where email='" + email+"'";
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

	//enable = true = user is enabled
	//enable = false = user is disabled
	@Override @Transactional
	public void enableUser(int uId, boolean enable) {
		Query query = sessionFactory.getCurrentSession().createQuery("update User set enabled='"+enable+"' where uId="+uId);	
		query.executeUpdate();
	}

	
}
