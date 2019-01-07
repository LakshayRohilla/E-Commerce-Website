package com.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SupplierDao;
import com.model.Category;
import com.model.Supplier;

@Transactional
@Repository("supplierDao")



public class SupplierDaoImpl implements SupplierDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean insertOrUpdateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
public List<Supplier> getSupplierDetails() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> supplierlist = session.createQuery("from Supplier").list();
		session.getTransaction().commit();
		return supplierlist;
	}


public Supplier getSupplier(int supp_id) {

	Session session = sessionFactory.openSession();
	Supplier supplier = session.get(Supplier.class, supp_id);
	return supplier;
}
public List<Supplier> retrieve()
{
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	List<Supplier> li = session.createQuery("from Supplier").list();
	session.getTransaction().commit();
	return li;
}

public void deleteSupp(int supp_id)
{
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	Supplier s = (Supplier)session.get(Supplier.class, supp_id);
	session.delete(s);
	session.getTransaction().commit();
}
}
