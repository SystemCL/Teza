package com.vlad.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="priority")
public class Priority {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nomPriority")
	private String nomPriority;
	
	@OneToMany(mappedBy="priority", targetEntity = Ticket.class, cascade=CascadeType.REMOVE, fetch = FetchType.EAGER) 
	@JsonBackReference
	private Set<Ticket> tickets;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomPriority() {
		return nomPriority;
	}
	public void setNomPriority(String nomPriority) {
		this.nomPriority = nomPriority;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
