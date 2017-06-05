package com.vlad.tickets.service;

import com.vlad.model.User;

public interface UserService {
	
	public void save(User user);

	public User findByUserName(String username);

}
