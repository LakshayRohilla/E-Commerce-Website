package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ProductDao;
import com.model.Category;
import com.model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void insertOrUpdateProduct(Product product) {
		
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public int getProductIdByProductName(String pro_name) {
		Session session = sessionFactory.getCurrentSession();
		int pid = 0;
		try
		{
			
			System.out.println("PRODUCT NAME----"+pro_name);
			
			pid = (Integer) session.createSQLQuery("select pro_id from Product where pro_name=:pro_name").setString("pro_name", pro_name).uniqueResult();
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			
		}
		return pid;
	}

	
	
	public Product getProduct(int pro_id) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, pro_id);
		session.close();
		return product;
	}


	public List<Product> retrieve()
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product> li = session.createQuery("from Product").list();
		session.getTransaction().commit();
		return li;
	}


	public List<Product> getProductByCatID(int cid) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> c = null;
		try
		{
			
			c = session.createQuery("from Product where cid=:cid").setInteger("cid", cid).list();
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			
		}
		return c;
	}

	public List<Product> getProductDetails() {

		Session session = sessionFactory.openSession();
		List<Product> productList = session.createQuery("from Product").list();
		session.close();
		return productList;
	}


	public void deleteProd(int pro_id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product p = (Product)session.get(Product.class, pro_id);
		session.delete(p);
		session.getTransaction().commit();
	}
}
