package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.vlad.model.Project;
import com.vlad.model.Ticket;
import com.vlad.model.Utilisateur;

@Repository
public class TicketDAOImpl implements TicketDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addTicket(Ticket ticket) {
		getCurrentSession().save(ticket);
		
	}

	@Override
	public void updateTicket(Ticket ticket) {
		Ticket ticketToUpdate = getTicket(ticket.getId());
		ticketToUpdate.setNomTicket(ticket.getNomTicket());
		ticketToUpdate.setDateCreationT(ticket.getDateCreationT());
		ticketToUpdate.setSujetTicket(ticket.getSujetTicket());
		getCurrentSession().update(ticketToUpdate);
		
	}

	@Override
	public Ticket getTicket(int id) {
		Ticket ticket = (Ticket) getCurrentSession().get(Ticket.class, id);
		return ticket;
	}

	@Override
	public void deleteTicket(int id) {
		Ticket ticket = getTicket(id);
		if(ticket != null)
			getCurrentSession().delete(ticket);	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTickets() {
		return getCurrentSession().createQuery("from Ticket").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects() {
		return getCurrentSession().createQuery("from Project").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> getUtilisateurs() {
		return getCurrentSession().createQuery("from Utilisateur").list();
	}

}
