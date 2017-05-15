package com.vlad.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vlad.model.Permission;
import com.vlad.model.Priority;
import com.vlad.model.Project;
import com.vlad.model.Ticket;
import com.vlad.model.User;
import com.vlad.model.Utilisateur;
import com.vlad.tickets.service.TicketService;

@Controller
@RequestMapping(value = "/ticket")
@Configuration
@ComponentScan("com.vlad.tickets.service")
/*
 * @FilterDef(name="addressFilter", parameters=@ParamDef(
 * name="addressFilterParam", type="date" ) )
 */
/* @PersistenceContext(type=PersistenceContextType.EXTENDED) */
public class TicketController {

	// trebuie de uitat si la Project, de adaugat la /add si la /edit
	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addTicketPage(Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView("add-ticket-form");
		List<Project> projects = ticketService.getProjects();
		List<Utilisateur> utilisateurs = ticketService.getUtilisateurs();
		List<Permission> permissions = ticketService.getPermissions();
		List<Priority> priorities = ticketService.getPriorities();
		map.put("ticket", new Ticket());
		modelAndView.addObject("utilisateursList", utilisateurs);
		modelAndView.addObject("projectsList", projects);
		modelAndView.addObject("permissionsList", permissions);
		modelAndView.addObject("prioritiesList", priorities);
		modelAndView.addObject("ticket", new Ticket());

		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingTicket(@ModelAttribute Ticket ticket) {
		ModelAndView modelAndView = new ModelAndView("home");
		ticketService.addTicket(ticket);
		String message = "Ticket was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}


	@RequestMapping(value="/list")
	public ModelAndView listOfTickets() {
		ModelAndView modelAndView = new ModelAndView("list-of-tickets");
		
		List<Ticket> tickets = ticketService.getTickets();
		modelAndView.addObject("tickets", tickets);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTicketPage(@PathVariable Integer id, Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView("edit-ticket-form");
		List<Project> projects = ticketService.getProjects();
		List<Utilisateur> utilisateurs = ticketService.getUtilisateurs();
		List<Permission> permissions = ticketService.getPermissions();
		List<Priority> priorities = ticketService.getPriorities();
		// Hibernate.initialize(addressService.);
		map.put("ticket", new Ticket());
		Ticket ticket = ticketService.getTicket(id);
		modelAndView.addObject("utilisateursList", utilisateurs);
		modelAndView.addObject("projectsList", projects);
		modelAndView.addObject("permissionsList", permissions);
		modelAndView.addObject("prioritiesList", priorities);
		modelAndView.addObject("ticket", ticket);

		return modelAndView;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTicket(@ModelAttribute Ticket ticket, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		ticketService.updateTicket(ticket);
		String message = "Ticket was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTicket(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		ticketService.deleteTicket(id);
		String message = "Ticket was successfully deleted.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
