package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.Permission;
import com.vlad.model.Priority;
import com.vlad.model.Project;
import com.vlad.model.Ticket;
import com.vlad.model.Utilisateur;

public interface TicketService {
	
	public void addTicket(Ticket ticket);
	public void updateTicket(Ticket ticket);
	public Ticket getTicket(int id);
	public void deleteTicket(int id);
	public List<Ticket> getTickets();
	public List<Permission> getPermissions();
	public List<Priority> getPriorities();
	public List<Project> getProjects();
	public List<Utilisateur> getUtilisateurs();
	

}
