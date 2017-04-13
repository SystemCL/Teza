package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.Permission;
import com.vlad.model.Permission;

@Repository
public class PermissionDAOImpl implements PermissionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addPermission(Permission permission) {
		getCurrentSession().save(permission);
		
	}

	@Override
	public void updatePermission(Permission permission) {
		Permission permissionToUpdate = getPermission(permission.getId());
		permissionToUpdate.setNomPermission(permission.getNomPermission());
		permissionToUpdate.setBitwise((permission.getBitwise()));
		//permissionToUpdate.setUserAssignPermission(permission.getUserAssignPermission());
		getCurrentSession().update(permissionToUpdate);
		
	}

	@Override
	public void deletePermission(int id) {
		Permission permission = getPermission(id);
		if(permission != null)
			getCurrentSession().delete(permission);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissions() {
		return getCurrentSession().createQuery("from Permission").list();
	}

	@Override
	public Permission getPermission(int id) {
		// TODO Auto-generated method stub
		Permission permission = (Permission) getCurrentSession().get(Permission.class, id);
		return permission;
	}

}
