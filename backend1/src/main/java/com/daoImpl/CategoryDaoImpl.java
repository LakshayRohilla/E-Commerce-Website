package com.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDao;
import com.model.Category;
import com.model.User;



@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao
{
	
	

	@Autowired
	SessionFactory sessionFactory;
	/*public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	*/
	public boolean insertOrUpdateCategory(Category category) 
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Category> retrieve()
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> li = session.createQuery("from Category").list();
		session.getTransaction().commit();
		return li;
	}
	
	
	public Category getCategory(int cat_id)
	{
		
		Session session =sessionFactory.openSession();
		Category category = session.get(Category.class,cat_id);
		return category;
	
	}
	
	public  int getCategoryByPid(int pro_id)
	{
		Session session = sessionFactory.getCurrentSession();
		int pid = 0;
		try
		{
			
			System.out.println("PRODUCT NAME----"+pid);
			
			pid = (Integer) session.createSQLQuery("select cid from Product where pro_id=:pro_id").setInteger("pro_id", pro_id).uniqueResult();
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			
		}
		return pid;
	}
	
	public void deleteCat(int cat_id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category c = (Category)session.get(Category.class, cat_id);
		session.delete(c);
		session.getTransaction().commit();
	}
	
}
