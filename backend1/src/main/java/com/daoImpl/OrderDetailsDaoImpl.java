 package com.daoImpl;



import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CartDao;
import com.dao.OrderDetailsDao;
import com.model.Cart;
import com.model.Category;
import com.model.OrderDetails;
import com.model.Product;
import com.model.User;

@Repository("orderDetailsDao")
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDetailsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrderDetails(OrderDetails orderdetails)
	{
		Session session = sessionFactory.getCurrentSession();
	
		
		try {
			System.out.println("InsertOrUpdate");
			
			session.saveOrUpdate(orderdetails);
			//session.getTransaction().commit();
			
		} catch (HibernateException e) {
			System.out.println("Error");
			//session.getTransaction().commit();
			
		}
		
		System.out.println("Order Dao");
	
	}

	@Transactional
	public List<OrderDetails> getOrder(String userEmail) {
		
		Session session = sessionFactory.getCurrentSession();
		List<OrderDetails> orders = null;
		try 
		{
			Query query=session.createQuery("from OrderDetails where email=:email").setString("email",userEmail);
			
			
			orders=query.list();
			
			
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			
		}
		return orders;
	}

	
	/*@Transactional
	public OrderDetails getOrderDetails(String email) {


		System.out.println("getOrderDetails()");
		Session session = sessionFactory.getCurrentSession();
		OrderDetails order = null;
		try {
			Query query = session.createQuery("from OrderDetails where email:=email").setString("email", email);
		
			order = (OrderDetails) query.uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}*/
	@Transactional
	public List<Integer> getOrderId(int cartid)
	{
		System.out.println(cartid);
		Session session = sessionFactory.getCurrentSession();
		List<Integer> id = session.createSQLQuery("select orderid from OrderDetails where cartid= :cartid").setInteger("cartid", cartid).list();
		System.out.println(id);
		return id;
	}
	
	
	@Transactional
	public List<Date> getOrderDate(int cartid)
	{
		System.out.println(cartid);
		Session session = sessionFactory.getCurrentSession();
		List<Date> date = session.createSQLQuery("select orderplacedon from OrderDetails where cartid= :cartid").setInteger("cartid", cartid).list();
		System.out.println(date);
		return date;
	}
	
	
	public OrderDetails getOrderDetails(String email)
	{
		System.out.println("GetOrderDetails");
		Session session = sessionFactory.openSession();
		OrderDetails user = session.get(OrderDetails.class, email);
		
		//User user=(User)session.createQuery("from User where name=:name").setString("name",name).uniqueResult();
		
		
		System.out.println(email);
		session.close();
		return user;
	}

	@Transactional
	public void deleteOrderDetails(String email) {
		Session session = sessionFactory.getCurrentSession();
		
		List <OrderDetails> orders = null;
		Query query =session.createQuery("from OrderDetails where email=:email").setString("email",email);
		orders = query.list();
		for(OrderDetails orderDetails: orders)
		{
			session.delete(orderDetails);
		}
		
	}
	
}












































/*package com.niit.daoImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderDetailsDao;
import com.niit.model.OrderDetails;


@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	@Autowired
	SessionFactory sessionFactory;
	public OrderDetailsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrderDetails(OrderDetails orderDetails)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(orderDetails.getShipping());
		session.save(orderDetails.getBilling());
		session.save(orderDetails);
		}
	
	public OrderDetails getOrderDetails(String username,int cart_id)
	{
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from OrderDetails where username=:username and cart_id=:cart_id");
		q.setParameter("username", username);
		q.setParameter("cart_id", cart_id);
		List<OrderDetails> list=q.list();
		session.close();
		OrderDetails orderDetails=null;
		for(OrderDetails item:list)
			orderDetails=item;
		return orderDetails;
	}
	
	@Transactional
	public void deleteOrderDetails(String username)
	{
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from OrderDetails where username=:username");
		q.setParameter("username", username);
		List<OrderDetails> list=q.list();
		session.close();
		for(OrderDetails item:list){
		sessionFactory.getCurrentSession().delete(item.getBilling());
		sessionFactory.getCurrentSession().delete(item.getShipping());
		sessionFactory.getCurrentSession().delete(item);		
		}
	}
	
}

*/