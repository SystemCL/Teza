package com.vlad.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.vlad.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vlad.model.Project;

@Entity
@Table(name="ticket")
/*@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@ticketId")*/
public class Ticket extends AbstractTimestampEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nomTicket")
	private String nomTicket;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy.MM.dd")
	@Column(name = "dateCreationT", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date dateCreationT;
	
	@Column(name = "sujetTicket")
	private String sujetTicket;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@JsonManagedReference
    private Project project;
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "utilisateur_id")
	@JsonManagedReference
    private Utilisateur utilisateur;
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "priority_id")
	@JsonManagedReference
    private Priority priority;
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "permission_id")
	@JsonManagedReference
    private Permission permission;
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "typemessage_id")
	@JsonManagedReference
    private TypeMessage typeMessage;
	
	@OneToMany(mappedBy="ticket", targetEntity = StateTicket.class, cascade=CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY) 
	@JsonBackReference
	private Set<StateTicket> states;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomTicket() {
		return nomTicket;
	}
	public void setNomTicket(String nomTicket) {
		this.nomTicket = nomTicket;
	}
	public Date getDateCreationT() {
		return dateCreationT;
	}
	public void setDateCreationT(Date dateCreationT) {
		this.dateCreationT = dateCreationT;
	}
	public String getSujetTicket() {
		return sujetTicket;
	}
	public void setSujetTicket(String sujetTicket) {
		this.sujetTicket = sujetTicket;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public TypeMessage getTypemessage() {
		return typeMessage;
	}
	public void setTypemessage(TypeMessage typeMessage) {
		this.typeMessage = typeMessage;
	}
	public Set<StateTicket> getStates() {
		return states;
	}
	public void setStates(Set<StateTicket> states) {
		this.states = states;
	}
	
}
