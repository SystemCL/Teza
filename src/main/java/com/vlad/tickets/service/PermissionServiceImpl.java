package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.Permission;
import com.vlad.tickets.dao.PermissionDAO;

@Service(value="permissionDAO")
@Transactional
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDAO permissionDAO;
	
	@Override
	public void addPermission(Permission permission) {
		permissionDAO.addPermission(permission);
		
	}

	@Override
	public void updatePermission(Permission permission) {
		permissionDAO.updatePermission(permission);
		
	}

	@Override
	public Permission getPermission(int id) {
		return permissionDAO.getPermission(id);
		
	}

	@Override
	public void deletePermission(int id) {
		permissionDAO.deletePermission(id);
		
	}
	
	@Override
	public List<Permission> getPermissions() {
		return permissionDAO.getPermissions();
		
	}
	

}
