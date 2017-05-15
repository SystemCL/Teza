package com.vlad.web.controller.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vlad.model.Ticket;
import com.vlad.tickets.service.TicketService;

@RestController
@RequestMapping(value = "/ticket")
@Configuration
@ComponentScan("com.vlad.tickets.service")
public class TicketRestController {
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Ticket getTicketById(@PathVariable int id) {
		return ticketService.getTicket(id);
	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Ticket> listOfTicketsJson() {
		List<Ticket> tickets = ticketService.getTickets();
		return tickets;
	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.POST, headers = "Accept=application/json")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		ticketService.addTicket(ticket);
		return ticket;
	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		ticketService.updateTicket(ticket);
		return ticket;
	}
	
	@RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json") 
	public void deleteTicket(@PathVariable("id") int id) {
		ticketService.deleteTicket(id);
	}
}
