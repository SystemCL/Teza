package com.vlad.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.ProjectAssignTicket;
import com.vlad.tickets.dao.ProjectAssignTicketDAO;
import com.vlad.tickets.dao.UserAssignProjectDAO;

@Service(value="projectAssignTicketDAO")
@Transactional
public class ProjectAssignTicketServiceImpl implements ProjectAssignTicketService {

	@Autowired
	private ProjectAssignTicketDAO projectAssignTicketDAO;
	
	@Override
	public void addProjectAssignTicket(ProjectAssignTicket projectAssignTicket) {
		projectAssignTicketDAO.addProjectAssignTicket(projectAssignTicket);
		
	}

	@Override
	public void updateProjectAssignTicket(ProjectAssignTicket projectAssignTicket) {
		projectAssignTicketDAO.updateProjectAssignTicket(projectAssignTicket);
		
	}

	@Override
	public void deleteProjectAssignTicket(int id) {
		projectAssignTicketDAO.deleteProjectAssignTicket(id);
		
	}

	@Override
	public ProjectAssignTicket getProjectAssignTicket(int id) {
		
		return projectAssignTicketDAO.getProjectAssignTicket(id);
	}

}
