package com.vlad.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vlad.model.Project;
import com.vlad.model.ProjectAssignTicket;
import com.vlad.model.Ticket;
import com.vlad.model.UserAssignProject;
import com.vlad.model.Utilisateur;
import com.vlad.tickets.service.ProjectAssignTicketService;
import com.vlad.tickets.service.ProjectService;
import com.vlad.tickets.service.TicketService;

@Controller
@RequestMapping(value="/")
@Configuration
@ComponentScan("com.vlad.tickets.service")
public class ProjectAssignTicketController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ProjectAssignTicketService projectAssignTicketService;
	
	 @RequestMapping(value="/assign-ticket-project", method=RequestMethod.GET)
	 public ModelAndView assignTicketToProjectPage(Map<String, Object> map/*@ModelAttribute UserAssignProject userAssignProject*/){
		 ModelAndView modelAndView = new ModelAndView("assign-ticket-project");
		 List<Project> projects = projectService.getAllProjects();
		 List<Ticket> tickets = ticketService.getAllTickets();
		 map.put("assignticketproject", new ProjectAssignTicket());
		 modelAndView.addObject("projectsList", projects);
		 modelAndView.addObject("ticketsList", tickets);
		 modelAndView.addObject("assignticketproject", new ProjectAssignTicket());
		 return modelAndView;
		 
	 }
	 
	 @RequestMapping(value="/assign-ticket-project", method=RequestMethod.POST)
	 public ModelAndView assignTicketToProject(@ModelAttribute ProjectAssignTicket projectAssignTicket){
		 ModelAndView modelAndView = new ModelAndView("home");
		 projectAssignTicketService.addProjectAssignTicket(projectAssignTicket);
			
			String message = "Ticket has been successfully assigned to project.";
			modelAndView.addObject("message", message);
			
			return modelAndView;
		 
	 }
	
}
