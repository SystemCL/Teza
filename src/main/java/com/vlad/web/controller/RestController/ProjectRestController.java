package com.vlad.web.controller.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlad.model.DomainProject;
import com.vlad.model.Project;
import com.vlad.tickets.service.ProjectService;

@RestController
@RequestMapping(value = "/project")
@Configuration
@ComponentScan("com.vlad.tickets.service")
public class ProjectRestController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Project getProjectById(@PathVariable int id) {
		return projectService.getProject(id);
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Project> listOfProjectsJson() {
		List<Project> projects = projectService.getProjects();
		return projects;
	}

	@RequestMapping(value = "/projects", method = RequestMethod.POST, headers = "Accept=application/json")
	public Project addProject(@RequestBody Project project) {
		projectService.addProject(project);
		return project;

	}

	@RequestMapping(value = "/projects", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Project updateProject(@RequestBody Project project) {
		projectService.updateProject(project);
		return project;
	}
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json") 
	public void deleteProject(@PathVariable("id") int id) {
		projectService.deleteProject(id);
	}

}
