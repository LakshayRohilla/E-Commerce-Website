package com.dao;

import java.util.List;

import com.model.Category;
import com.model.Supplier;

public interface SupplierDao {

	public boolean insertOrUpdateSupplier(Supplier supplier);
	
	public List<Supplier> getSupplierDetails();
	public Supplier getSupplier(int supp_id);
	public List<Supplier> retrieve();
	public void deleteSupp(int supp_id);
	
}
