package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.vlad.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addProject(Project project) {
		getCurrentSession().save(project);
		
	}

	@Override
	public void updateProject(Project project) {
		Project projectToUpdate = getProject(project.getId());
		projectToUpdate.setNomProject(project.getNomProject());
		projectToUpdate.setDomain(project.getDomain());
		projectToUpdate.setDateCreationP(project.getDateCreationP());
		getCurrentSession().update(projectToUpdate);
		
	}

	@Override
	public Project getProject(int id) {
		Project project = (Project) getCurrentSession().get(Project.class, id);
		return project;
	}

	@Override
	public void deleteProject(int id) {
		Project project = getProject(id);
		if(project != null)
			getCurrentSession().delete(project);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects() {
		return getCurrentSession().createQuery("from Project").list();
	}


}
