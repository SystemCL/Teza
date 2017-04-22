package com.vlad.tickets.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.vlad.model.Permission;
import com.vlad.model.Priority;
import com.vlad.model.Project;
import com.vlad.model.Ticket;
import com.vlad.model.User;
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
		ticketToUpdate.setUtilisateur(ticket.getUtilisateur());
		ticketToUpdate.setProject(ticket.getProject());
		ticketToUpdate.setPermission(ticket.getPermission());
		ticketToUpdate.setPriority(ticket.getPriority());
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Ticket WHERE utilisateur_id IN "
				+ "(SELECT id FROM Project WHERE id = "
				+ "(SELECT id FROM UserAssignProject WHERE id ="
				+ "(SELECT id FROM Utilisateur WHERE id ="
				+ "(SELECT id FROM User WHERE username = :username))))"); 
		
		query.setParameter("username", userName);
		List<Ticket> list = query.list();
		return list;
		
		/*return getCurrentSession().createQuery("FROM Ticket WHERE utilisateur_id IN "
				+ "(SELECT id FROM Project WHERE id = "
				+ "(SELECT id FROM UserAssignProject WHERE id ="
				+ "(SELECT id FROM Utilisateur WHERE id ="
				+ "(SELECT id FROM User WHERE id = 2))))").list();*/
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

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissions() {
		return getCurrentSession().createQuery("from Permission").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Priority> getPriorities() {
		return getCurrentSession().createQuery("from Priority").list();
	}


	
}
