package com.vlad.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="projectAssignTicket")
public class ProjectAssignTicket {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy.MM.dd")
	@Column(name = "dateCreationProjectAssignTicket", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date dateCreationProjectAssignTicket;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	@JsonManagedReference
    private Project project;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_id")
	@JsonManagedReference
    private Ticket ticket;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCreationProjectAssignTicket() {
		return dateCreationProjectAssignTicket;
	}

	public void setDateCreationProjectAssignTicket(Date dateCreationProjectAssignTicket) {
		this.dateCreationProjectAssignTicket = dateCreationProjectAssignTicket;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
