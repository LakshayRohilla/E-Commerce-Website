package com.dao;

import java.util.List;

import com.model.Category;
import com.model.Product;

public interface CategoryDao {

	public boolean insertOrUpdateCategory(Category category);
	public List<Category> retrieve();
	public Category getCategory(int cat_id);
	public int getCategoryByPid(int pid);
	

	
	public void deleteCat(int cat_id);
}
