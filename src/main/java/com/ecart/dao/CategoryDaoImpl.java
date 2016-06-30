package com.ecart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.model.Category;


@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override @Transactional
	public List<Category> getCategoryList() {
		return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}

	@Override @Transactional
	public Category getCategory(int cId) {
		String hql = "from Category where cId=" + cId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> categoryList =  query.list();
		if(categoryList != null && !categoryList.isEmpty()){
			return categoryList.get(0);
		}
		return null;
	}

	@Override @Transactional
	public void saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

	@Override @Transactional
	public void deleteCategory(int cId) {
		Category category = new Category();
		category = getCategory(cId);
		sessionFactory.getCurrentSession().delete(category);
	}

}
