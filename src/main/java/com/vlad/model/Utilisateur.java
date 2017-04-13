package com.vlad.model;

import java.util.HashSet;
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

import com.vlad.model.Ticket;
import com.vlad.model.Project;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "age")
	private int age;
	@OneToMany( /*fetch = FetchType.EAGER,*/ mappedBy="utilisateur", targetEntity = Ticket.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	private Set<Ticket> tickets = new HashSet<Ticket>(0);
	@OneToMany(mappedBy="utilisateur", targetEntity=UserAssignProject.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<UserAssignProject> userAssignProjects = new HashSet<UserAssignProject>(0);
	@OneToMany(mappedBy="utilisateur", targetEntity=Message.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Message> messages = new HashSet<Message>(0);
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	public Set<Message> getMessage() {
		return messages;
	}
	public void setMessage(Set<Message> messages) {
		this.messages = messages;
	}
	
	public Set<Ticket> tickets(Set<Ticket> tickets){
		this.tickets = tickets;
		return tickets;
	}
	
	public Set<UserAssignProject> userAssignProjects(Set<UserAssignProject> userAssignProjects ) {
		this.userAssignProjects = userAssignProjects;
		return userAssignProjects;
	}
	
	public Set<Message> messages(Set<Message> messages ) {
		this.messages = messages;
		return messages;
	}
	
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	

}
