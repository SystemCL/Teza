package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.Project;
import com.vlad.model.Ticket;
import com.vlad.model.Utilisateur;
import com.vlad.tickets.dao.TicketDAO;


@Service(value="ticketDAO")
@Transactional
public class TicketServiceImpl  implements TicketService{

	@Autowired
	private TicketDAO ticketDAO;
	
	@Override
	public void addTicket(Ticket ticket) {
		ticketDAO.addTicket(ticket);
		
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketDAO.updateTicket(ticket);
		
	}

	@Override
	public Ticket getTicket(int id) {
		return ticketDAO.getTicket(id);
		
	}

	@Override
	public void deleteTicket(int id) {
		ticketDAO.deleteTicket(id);
		
	}
	
	@Override
	public List<Ticket> getTickets() {
		return ticketDAO.getTickets();
		
	}

	@Override
	public List<Project> getProjects() {
		return ticketDAO.getProjects();
		
	}
	
	@Override
	public List<Utilisateur> getUtilisateurs() {
		return ticketDAO.getUtilisateurs();
		
	}



}
