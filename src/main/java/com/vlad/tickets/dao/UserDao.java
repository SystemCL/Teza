package com.vlad.tickets.dao;

import java.util.List;

import com.vlad.model.*;

public interface UserDao {
	
	public void save(User user);

	public User findByUserName(String username);
	
    public boolean isUserExists(User user);

    public List<UserRole> getSearchRoles();
}