package com.vlad.tickets.dao;

import com.vlad.model.ProjectAssignTicket;
import com.vlad.model.UserAssignProject;

public interface ProjectAssignTicketDAO {
	public void addProjectAssignTicket(ProjectAssignTicket projectAssignTicket);
	public void updateProjectAssignTicket(ProjectAssignTicket projectAssignTicket);
	public void deleteProjectAssignTicket(int id);
	public ProjectAssignTicket getProjectAssignTicket(int id);

}
