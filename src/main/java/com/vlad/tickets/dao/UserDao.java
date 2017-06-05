package com.vlad.tickets.dao;

import com.vlad.model.*;

public interface UserDao {
	
	public void save(User user);

	public User findByUserName(String username);
	


}