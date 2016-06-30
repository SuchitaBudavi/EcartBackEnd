package com.ecart.dao;

import java.util.List;

import com.ecart.model.Category;

public interface CategoryDao {

    public List<Category> getCategoryList();
	
	public Category getCategory(int cId);
	
	public void saveOrUpdate(Category category);
	
	public void deleteCategory(int cId);
}
