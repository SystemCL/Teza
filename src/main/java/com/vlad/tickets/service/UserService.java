package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.User;
import com.vlad.model.UserRole;

public interface UserService {
	
	public void save(User user);

	public User findByUserName(String username);
	
	public List<UserRole> getSearchRoles();

}
