package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {
	
	public void insertOrUpdateProduct(Product product);
	public List<Product> retrieve();
	public List<Product> getProductByCatID(int cat_id);
	
	public Product getProduct( int pid);
	
	public void deleteProd(int pro_id);
	
	public int getProductIdByProductName(String pro_name) ;
		
}
