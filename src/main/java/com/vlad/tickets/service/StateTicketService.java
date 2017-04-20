package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.StateTicket;

public interface StateTicketService {
	public void addStateTicket(StateTicket stateTicket);
	public void updateStateTicket(StateTicket stateTicket);
	public StateTicket getStateTicket(int id);
	public void deleteStateTicket(int id);
	public List<StateTicket> getStateTickets();

}
