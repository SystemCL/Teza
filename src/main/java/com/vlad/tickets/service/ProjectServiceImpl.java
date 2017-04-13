package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.Project;
import com.vlad.tickets.dao.ProjectDAO;


@Service(value="projectDAO")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public void addProject(Project project) {
		projectDAO.addProject(project);
		
	}

	@Override
	public void updateProject(Project project) {
		projectDAO.updateProject(project);
		
	}

	@Override
	public Project getProject(int id) {
		return projectDAO.getProject(id);
		
	}

	@Override
	public void deleteProject(int id) {
		projectDAO.deleteProject(id);
		
	}
	
	@Override
	public List<Project> getProjects() {
		return projectDAO.getProjects();
		
	}

}
