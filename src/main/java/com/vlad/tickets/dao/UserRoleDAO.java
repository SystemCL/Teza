package com.vlad.tickets.dao;

import com.vlad.model.DomainProject;
import com.vlad.model.Message;
import com.vlad.model.UserRole;


public interface UserRoleDAO {
	public void addUserRole(UserRole userRole);
	public void searchUserRole(String text);
	public void updateUserRole(UserRole userRole);
	public UserRole getUserRole(int id);
	public void deleteUserRole(int id);

}
