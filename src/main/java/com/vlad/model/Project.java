package com.vlad.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.vlad.model.Ticket;

@Entity
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "nomProject")
	private String nomProject;
	@Column(name = "domain")
	private String domain;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy.MM.dd")
	@Column(name = "dateCreationP")
	private Date dateCreationP;
	@OneToMany( /*fetch = FetchType.EAGER,*/ mappedBy="project", targetEntity = Ticket.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	private Set<Ticket> tickets = new HashSet<Ticket>(0);
	@OneToMany( /*fetch = FetchType.EAGER,*/ mappedBy="project", targetEntity = UserAssignProject.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	private Set<UserAssignProject> userAssignProjects = new HashSet<UserAssignProject>(0);

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomProject() {
		return nomProject;
	}
	public void setNomProject(String nomProject) {
		this.nomProject = nomProject;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Date getDateCreationP() {
		return dateCreationP;
	}
	public void setDateCreationP(Date dateCreationP) {
		this.dateCreationP = dateCreationP;
	}
	
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public Set<UserAssignProject> getUserAssignProjects() {
		return userAssignProjects;
	}
	public void setUserAssignProjects(Set<UserAssignProject> userAssignProjects) {
		this.userAssignProjects = userAssignProjects;
	}
	
	
	public Set<Ticket> tickets(Set<Ticket> tickets){
		this.tickets = tickets;
		return tickets;
	}
	
	public Set<UserAssignProject> userAssignProjects(Set<UserAssignProject> userAssignProjects){
		this.userAssignProjects = userAssignProjects;
		return userAssignProjects;
	}
	
	
}
