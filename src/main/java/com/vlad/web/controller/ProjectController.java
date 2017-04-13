package com.vlad.web.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.vlad.model.Project;
import com.vlad.tickets.service.ProjectService;



@Controller
@RequestMapping(value="/project")
@Configuration
@ComponentScan("com.vlad.tickets.service")
public class ProjectController {

	@Autowired
	private ProjectService projectService; //student

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addprojectPage() {
		ModelAndView modelAndView = new ModelAndView("add-project-form");
		modelAndView.addObject("project", new Project());
		return modelAndView;
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingproject(@ModelAttribute Project project) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		projectService.addProject(project);
		
		String message = "project was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfprojects() {
		ModelAndView modelAndView = new ModelAndView("list-of-projects");
		
		List<Project> projects = projectService.getProjects();
		modelAndView.addObject("projects", projects);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editprojectPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-project-form");
		Project project = projectService.getProject(id);
		modelAndView.addObject("project",project);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingproject(@ModelAttribute Project project, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		projectService.updateProject(project);
		
		String message = "project was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteproject(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		projectService.deleteProject(id);
		String message = "project was successfully deleted.";
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
