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
import com.vlad.model.UserAssignProject;
import com.vlad.model.Utilisateur;
import com.vlad.tickets.service.ProjectService;
import com.vlad.tickets.service.UserAssignProjectService;
import com.vlad.tickets.service.UtilisateurService;

@Controller
@RequestMapping(value="/")
@Configuration
@ComponentScan("com.vlad.tickets.service")
public class UserAssignProjectController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private ProjectService projectService;
	
    @Autowired
    private UserAssignProjectService userAssignProjectService;
	
	 @RequestMapping(value="/assign-user-project", method=RequestMethod.GET)
	 public ModelAndView assignUserToProjectPage(Map<String, Object> map/*@ModelAttribute UserAssignProject userAssignProject*/){
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
		 
	 }
}
