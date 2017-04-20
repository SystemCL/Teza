package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.UserAssignProject;
import com.vlad.tickets.dao.UserAssignProjectDAO;

@Service(value="userAssignProjectDAO")
@Transactional
public class UserAssignProjectServiceImpl implements UserAssignProjectService {
	@Autowired
	private UserAssignProjectDAO userAssignProjectDAO;
	
	@Override
	public void addUserAssignProject(UserAssignProject userAssignProject) {
		userAssignProjectDAO.addUserAssignProject(userAssignProject);
		
	}

	@Override
	public void updateUserAssignProject(UserAssignProject userAssignProject) {
		userAssignProjectDAO.updateUserAssignProject(userAssignProject);
		
	}

	@Override
	public UserAssignProject getUserAssignProject(int id) {
		return userAssignProjectDAO.getUserAssignProject(id);
		
	}

	@Override
	public void deleteUserAssignProject(int id) {
		userAssignProjectDAO.deleteUserAssignProject(id);
		
	}
	
	@Override
	public List<UserAssignProject> getUserAssignProjects() {
		return userAssignProjectDAO.getUserAssignProjects();
		
	}
	

}
