package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.UserAssignProject;

@Repository
public class UserAssignProjectDAOImpl implements UserAssignProjectDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addUserAssignProject(UserAssignProject userAssignProject) {
		getCurrentSession().save(userAssignProject);
		
	}

	@Override
	public void updateUserAssignProject(UserAssignProject userAssignProject) {
		UserAssignProject userAssignProjectToUpdate = getUserAssignProject(userAssignProject.getId());
		userAssignProjectToUpdate.setDateCreationUserAssignProject(userAssignProject.getDateCreationUserAssignProject());
		//userAssignProjectToUpdate.setDateCreationM(userAssignProject.getDateCreationM());
        //
		getCurrentSession().update(userAssignProjectToUpdate);
		
	}

	@Override
	public void deleteUserAssignProject(int id) {
		UserAssignProject userAssignProject = getUserAssignProject(id);
		if(userAssignProject != null)
			getCurrentSession().delete(userAssignProject);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAssignProject> getUserAssignProjects() {
		return getCurrentSession().createQuery("from UserAssignProject").list();
	}

	@Override
	public UserAssignProject getUserAssignProject(int id) {
		UserAssignProject userAssignProject = (UserAssignProject) getCurrentSession().get(UserAssignProject.class, id);
		return userAssignProject;
	}

}
