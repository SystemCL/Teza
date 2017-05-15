package com.vlad.web.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.vlad.model.DomainProject;
import com.vlad.model.Project;
import com.vlad.model.Ticket;
import com.vlad.tickets.service.ProjectService;


@Controller
@RequestMapping(value="/project")
@Configuration
@RestController
@ComponentScan("com.vlad.tickets.service")
public class ProjectController {

	@Autowired
	private ProjectService projectService;


	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addprojectPage(Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView("add-project-form");
		List<DomainProject> domains = projectService.getDomains();
		map.put("project", new Project());
		modelAndView.addObject("domainsList", domains);
		modelAndView.addObject("project", new Project());
		return modelAndView;
	}
	
	@POST
	@Consumes("application/json")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingproject(@ModelAttribute Project project) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		projectService.addProject(project);
		
		String message = "project was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET )
	@ResponseBody
	public ModelAndView listOfprojects() {
		ModelAndView modelAndView = new ModelAndView("list-of-projects");
		
		List<Project> projects = projectService.getProjects();
		DomainProject domain = projectService.getDomain(2);
		modelAndView.addObject("domain", domain);
		modelAndView.addObject("projects", projects);
		
		return modelAndView;
	}
	
	/*@RequestMapping(value="/list-projects-json", method=RequestMethod.GET, headers = "Accept=application/json" )
	public List<Project> listOfprojectsJson() {
		
		List<Project> projects = projectService.getProjects();
		return projects;
	}*/
	
	
	@RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> bar() {
	    final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<String>("{\"test\": \"jsonResponseExample\"}", httpHeaders, HttpStatus.OK);
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes("application/json")
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editprojectPage(@PathVariable Integer id, Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView("edit-project-form");
		List<DomainProject> domains = projectService.getDomains();
		map.put("ticket", new Ticket());
		Project project = projectService.getProject(id);
		modelAndView.addObject("domainsList", domains);
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
	
	@DELETE
	@Path("/delete/{id}")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteproject(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		projectService.deleteProject(id);
		String message = "project was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping("/search")
	  public ModelAndView search(@RequestParam(value="searchTerm", required = false) @PathVariable("searchTerm") String pSearchTerm, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("list-of-projects");
		List<Project> pSearchResult = projectService.getSearchProjects(pSearchTerm);
		modelAndView.addObject("searchTerm", pSearchTerm);
		modelAndView.addObject("searchResult", pSearchResult);
		
		/*List<Project> searchResults = null;
	    try {
	      searchResults = projectService.getSearchProjects(q);
	    }
	    catch (Exception ex) {
	      // here you should handle unexpected errors
	      // ...
	      // throw ex;
	    }
	    //model.addAttribute("searchResults", searchResults);
	    model.addAttribute("projectsSearch", searchResults);*/
		request.setAttribute("searchResult",pSearchResult);
	    return modelAndView;
	  }
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
