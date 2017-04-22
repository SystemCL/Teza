package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


import com.vlad.model.Project;
import com.vlad.model.User;

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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String userName = auth.getName();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Project WHERE id IN "
				+ "(SELECT project FROM UserAssignProject WHERE utilisateur = "
				+ "(SELECT id FROM Utilisateur WHERE id ="
				+ "(SELECT userUtilisateur FROM User WHERE username = :username))) order by id asc");
		if(auth instanceof UserDetails) {
			String userName = ((UserDetails)auth).getUsername();
			query.setParameter("username", userName);
			List<Project> list = query.list();
			return list;
		} else {
			String userName = auth.getName();
			query.setParameter("username", userName);
			List<Project> list = query.list();
			return list;
		}
		
		
		//User user = (User)SecurityContextHolder.getContext().getAuthentication();
		
		//String userName = user.getUsername();

		
		
	}


}
