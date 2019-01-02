package com.dao;

import org.springframework.stereotype.Repository;

import com.model.User;

public interface userdao 
{
	public void insertOrUpdateUser(User user);
	public User getUser(String name);
	public String getUserName(String email);
}
