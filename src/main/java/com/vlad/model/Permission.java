package com.vlad.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="permission")
public class Permission {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "nomPermission")
	private String nomPermission;
	@Column(name = "bitwise")
	private String bitwise;
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "userassignproject_id")
    private UserAssignProject userAssignProject;
	@OneToMany(mappedBy="permission", targetEntity = Ticket.class, cascade=CascadeType.ALL /*, fetch = FetchType.EAGER*/) 
    private Set<Ticket> tickets;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomPermission() {
		return nomPermission;
	}
	public void setNomPermission(String nomPermission) {
		this.nomPermission = nomPermission;
	}
	public String getBitwise() {
		return bitwise;
	}
	public void setBitwise(String bitwise) {
		this.bitwise = bitwise;
	}
	public UserAssignProject getUserAssignProject() {
		return userAssignProject;
	}
	public void setUserAssignProject(UserAssignProject userAssignProject) {
		this.userAssignProject = userAssignProject;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
