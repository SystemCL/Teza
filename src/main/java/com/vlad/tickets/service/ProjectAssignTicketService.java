package com.vlad.tickets.service;

import com.vlad.model.ProjectAssignTicket;

public interface ProjectAssignTicketService {
	
	public void addProjectAssignTicket(ProjectAssignTicket projectAssignTicket);
	public void updateProjectAssignTicket(ProjectAssignTicket projectAssignTicket);
	public void deleteProjectAssignTicket(int id);
	public ProjectAssignTicket getProjectAssignTicket(int id);

}
