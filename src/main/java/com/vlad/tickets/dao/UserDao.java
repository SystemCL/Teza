package com.vlad.tickets.dao;

import com.vlad.model.*;

public interface UserDao {
	
	void save(User user);

	User findByUserName(String username);

}