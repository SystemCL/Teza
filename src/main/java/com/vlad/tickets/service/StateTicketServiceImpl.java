package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.StateTicket;
import com.vlad.tickets.dao.StateTicketDAO;

@Service(value="stateTicketDAO")
@Transactional
public class StateTicketServiceImpl implements StateTicketService {
	@Autowired
	private StateTicketDAO stateTicketDAO;
	
	@Override
	public void addStateTicket(StateTicket stateTicket) {
		stateTicketDAO.addStateTicket(stateTicket);
		
	}

	@Override
	public void updateStateTicket(StateTicket stateTicket) {
		stateTicketDAO.updateStateTicket(stateTicket);
		
	}

	@Override
	public StateTicket getStateTicket(int id) {
		return stateTicketDAO.getStateTicket(id);
		
	}

	@Override
	public void deleteStateTicket(int id) {
		stateTicketDAO.deleteStateTicket(id);
		
	}
	
	@Override
	public List<StateTicket> getStateTickets() {
		return stateTicketDAO.getStateTickets();
		
	}

}
