package com.daoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.userdao;
import com.model.User;

@Transactional
@Repository("userDao")
public class userdaoimpl implements userdao
{
	@Autowired
	private SessionFactory sessionfactory;
	public void insertOrUpdateUser(User user) 
	{
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public User getUser(String email) {

		System.out.println("GetUser");
		Session session = sessionfactory.openSession();
		User user = session.get(User.class, email);
		
		//User user=(User)session.createQuery("from User where name=:name").setString("name",name).uniqueResult();
		
		
		System.out.println(email);
		session.close();
		return user;
		
	}
	public String getUserName(String email) {
		Session session =sessionfactory.openSession();
		String name = (String)session.createQuery("select name from User where emailid=:email").setString("email", email).uniqueResult();
		System.out.println(name);
		session.close();
		return name;
	}

}
