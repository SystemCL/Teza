package com.vlad.web.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vlad.model.DomainProject;
import com.vlad.model.Project;
import com.vlad.model.UserAssignProject;
import com.vlad.model.UserRole;
import com.vlad.model.Utilisateur;
import com.vlad.tickets.service.ProjectService;
import com.vlad.tickets.service.UserAssignProjectService;
import com.vlad.tickets.service.UserService;
import com.vlad.tickets.service.UtilisateurService;

@Controller
@RequestMapping(value="/utilisateur")
@Configuration
@ComponentScan("com.vlad.tickets.service")
/*@FilterDef(name="addressFilter",
parameters=@ParamDef( name="addressFilterParam", type="date" ) )*/
/*@PersistenceContext(type=PersistenceContextType.EXTENDED)*/
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
    @Autowired
    private UserAssignProjectService userAssignProjectService;
	
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView addUtilisateurPage(Map<String, Object> map) {
		 ModelAndView modelAndView = new ModelAndView("add-utilisateur-form");
		 //List<UserRole> userRoles = userService.getSearchRoles();
		 
		// modelAndView.addObject("userRolesList", userRoles);
		 modelAndView.addObject("utilisateur", new Utilisateur());
		 
		 return modelAndView;
	 }
	
	
	 @RequestMapping(value="/add", method=RequestMethod.POST)
	 public ModelAndView addingUtilisateur(@ModelAttribute Utilisateur utilisateur, HttpServletRequest request) {
		 ModelAndView modelAndView = new ModelAndView("home");
		 String fullname = request.getParameter("firstName") + " " + request.getParameter("lastName");
		 utilisateur.setFullName(fullname);
		 utilisateurService.addUtilisateur(utilisateur);
		 String message = "User was successfully added.";
		 modelAndView.addObject("message", message );
		 
		 return modelAndView;
	 }
	 
	 @RequestMapping(value="/list")
	 public ModelAndView listOfUtilisateurs() {
		 ModelAndView modelAndView = new ModelAndView("list-of-utilisateurs");
		 List<Utilisateur> utilisateurs = utilisateurService.getUtilisateurs();
		 modelAndView.addObject("utilisateurs", utilisateurs);
		 
		 return modelAndView;
		 
	 }
	 
	
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	 public ModelAndView editUtilisateurPage(@PathVariable Integer id/*, Map<String, Object> map*/) {
		 ModelAndView modelAndView = new ModelAndView("edit-utilisateur-form");
		// List<Project> projects = utilisateurService.getProjects();
		// Hibernate.initialize(addressService.);
		// model.put("utilisateur", new Utilisateur());
		 Utilisateur utilisateur = utilisateurService.getUtilisateur(id);
		 //modelAndView.addObject("projectsList", projects);
		 modelAndView.addObject("utilisateur", utilisateur);
		 
		 return modelAndView;
		 
	 }
	 
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	 public ModelAndView edditingUtilisateur(@ModelAttribute Utilisateur utilisateur, @PathVariable Integer id) {
		 ModelAndView modelAndView = new ModelAndView("home");
		 utilisateurService.updateUtilisateur(utilisateur);
		 String message = "Utilisateur was successfully edited.";
		 modelAndView.addObject("message", message);
		 
		 return modelAndView; 
	 }
	 
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView deleteUtilisateur(@PathVariable Integer id) {
		 ModelAndView modelAndView = new ModelAndView("home");
		 utilisateurService.deleteUtilisateur(id);
		 String message = "Utilisateur was successfully deleted.";
		 modelAndView.addObject("message", message);
		
		 return modelAndView;
	 }
	 
/*	 @RequestMapping(value="/assign-user-project", method=RequestMethod.GET)
	 public ModelAndView assignUserToProjectPage(Map<String, Object> map@ModelAttribute UserAssignProject userAssignProject){
		 ModelAndView modelAndView = new ModelAndView("assign-user-project");
		 List<Project> projects = projectService.getAllProjects();
		 List<Utilisateur> utilisateurs = utilisateurService.getUtilisateurs();
		 map.put("assignuserproject", new UserAssignProject());
		 modelAndView.addObject("projectsList", projects);
		 modelAndView.addObject("utilisateursList", utilisateurs);
		 modelAndView.addObject("assignuserproject", new UserAssignProject());
		 return modelAndView;
		 
	 }
	 
	 @RequestMapping(value="/assign-user-project", method=RequestMethod.POST)
	 public ModelAndView assignUserToProject(@ModelAttribute UserAssignProject userAssignProject){
		 ModelAndView modelAndView = new ModelAndView("home");
			userAssignProjectService.addUserAssignProject(userAssignProject);
			
			String message = "User has been successfully assigned to project.";
			modelAndView.addObject("message", message);
			
			return modelAndView;
		 
	 }*/


}
