package com.vlad.tickets.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.ProjectAssignTicket;
import com.vlad.model.UserAssignProject;

@Repository
public class ProjectAssignTicketDAOImpl implements ProjectAssignTicketDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addProjectAssignTicket(ProjectAssignTicket projectAssignTicket) {
		getCurrentSession().save(projectAssignTicket);
		
	}

	@Override
	public void updateProjectAssignTicket(ProjectAssignTicket projectAssignTicket) {

		ProjectAssignTicket projectAssignTicketToUpdate = getProjectAssignTicket(projectAssignTicket.getId());
		projectAssignTicketToUpdate.setDateCreationProjectAssignTicket(projectAssignTicket.getDateCreationProjectAssignTicket());
		getCurrentSession().update(projectAssignTicketToUpdate);
	}

	@Override
	public void deleteProjectAssignTicket(int id) {
		ProjectAssignTicket projectAssignTicket = getProjectAssignTicket(id);
		if(projectAssignTicket != null)
			getCurrentSession().delete(projectAssignTicket);	
		
	}

	@Override
	public ProjectAssignTicket getProjectAssignTicket(int id) {
		ProjectAssignTicket projectAssignTicket = (ProjectAssignTicket) getCurrentSession().get(ProjectAssignTicket.class, id);
		return projectAssignTicket;
	}

}
