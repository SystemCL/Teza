package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.StateTicket;

@Repository
public class StateTicketDAOImpl implements StateTicketDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addStateTicket(StateTicket stateTicket) {
		getCurrentSession().save(stateTicket);
		
	}

	@Override
	public void updateStateTicket(StateTicket stateTicket) {
		StateTicket stateTicketToUpdate = getStateTicket(stateTicket.getId());
		stateTicketToUpdate.setNomStateTicket(stateTicket.getNomStateTicket());
		//stateTicketToUpdate.setBitwise((stateTicket.getBitwise()));
		//stateTicketToUpdate.setUserAssignStateTicket(stateTicket.getUserAssignStateTicket());
		getCurrentSession().update(stateTicketToUpdate);
		
	}

	@Override
	public void deleteStateTicket(int id) {
		StateTicket stateTicket = getStateTicket(id);
		if(stateTicket != null)
			getCurrentSession().delete(stateTicket);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StateTicket> getStateTickets() {
		return getCurrentSession().createQuery("from StateTicket").list();
	}

	@Override
	public StateTicket getStateTicket(int id) {
		StateTicket stateTicket = (StateTicket) getCurrentSession().get(StateTicket.class, id);
		return stateTicket;
	}

}
