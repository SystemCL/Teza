package com.vlad.tickets.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.vlad.model.DomainProject;
import com.vlad.model.Project;
import com.vlad.model.Ticket;
import com.vlad.model.User;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addProject(Project project) {
		getCurrentSession().save(project);
		
	}

	@Override
	public void updateProject(Project project) {
		Project projectToUpdate = getProject(project.getId());
		projectToUpdate.setNomProject(project.getNomProject());
		projectToUpdate.setDomainProject(project.getDomainProject());
		//projectToUpdate.setDateCreationP(project.getDateCreationP());
		//projectToUpdate.setCreated(project.getDateCreationP());
		projectToUpdate.setDateCreationP(project.getDateCreationP());
		//projectToUpdate.setBeginninglife1(project.getBeginninglife1());

		getCurrentSession().update(projectToUpdate);

		//sessionFactory.getCurrentSession().merge(project);
	}

	@Override
	public Project getProject(int id) {
		Project project = (Project) getCurrentSession().get(Project.class, id);
		return project;
	}

	@Override
	public void deleteProject(int id) {
		Project project = getProject(id);
		if(project != null)
			//project.getTickets().remove(project);
		    //project.getUserAssignProjects().remove(project);
		    /*project.getTickets().clear();
	        project.getUserAssignProjects().clear();*/
			project.getTickets().remove(project);
		    project.getUserAssignProjects().remove(project);
		    getCurrentSession().flush();
		    project = (Project) getCurrentSession().merge(project);
			//getCurrentSession().flush();
			//getCurrentSession().delete(object);
		    //Nu se sterge din baza de date
		    //https://stackoverflow.com/questions/26532275/hibernate-how-to-correctly-delete-children-in-onetomany
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String userName = auth.getName();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Project WHERE id IN "
				+ "(SELECT project FROM UserAssignProject WHERE utilisateur = "
				+ "(SELECT id FROM Utilisateur WHERE id ="
				+ "(SELECT userUtilisateur FROM User WHERE username = :username))) order by id asc");
		if(auth instanceof UserDetails) {
			String userName = ((UserDetails)auth).getUsername();
			query.setParameter("username", userName);
			List<Project> list = query.list();
			return list;
		} else {
			String userName = auth.getName();
			query.setParameter("username", userName);
			List<Project> list = query.list();
			return list;
		}
		
		//User user = (User)SecurityContextHolder.getContext().getAuthentication();	
		//String userName = user.getUsername();
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DomainProject> getDomains() {
		return getCurrentSession().createQuery("from DomainProject").list();
	}

	@Override
	public DomainProject getDomain(int id) {
		DomainProject domain = (DomainProject) getCurrentSession().get(DomainProject.class, id);
		return domain;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getSearchProjects(String text) {
		// Lista Returneaza NULL
/*		FullTextSession fullTextSession = Search.getFullTextSession(getCurrentSession());
		QueryBuilder builder = fullTextSession.getSearchFactory()
				.buildQueryBuilder()
				.forEntity(Project.class)
				.get();
		org.apache.lucene.search.Query query =
				builder.keyword().wildcard().onField("nomProject").matching(text + "*").createQuery();
		System.out.println("======" + query.toString());
		
		org.hibernate.search.FullTextQuery ftq =
				fullTextSession.createFullTextQuery(query, Project.class);
		System.out.println("======" + ftq.toString());
		@SuppressWarnings("unchecked")
		List<Project> projectSearchList = ftq.list();*/
		
		Query query = sessionFactory.getCurrentSession().createQuery(
				"Select a FROM Project a WHERE a.nomProject like ?");
		query.setParameter(0, "%" + text + "%");
		@SuppressWarnings("unchecked")
		List<Project> list = new LinkedList<Project>();
		list = (List<Project>) query.list();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() {
		return getCurrentSession().createQuery("from Project").list();
		
	}


}
