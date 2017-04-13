package com.vlad.tickets.dao;

import java.util.List;

import com.vlad.model.Permission;


public interface PermissionDAO {
	public void addPermission(Permission permission);
	public void updatePermission(Permission permission);
	public Permission getPermission(int id);
	public void deletePermission(int id);
	public List<Permission> getPermissions();

}
