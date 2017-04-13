package com.vlad.model;

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

@Entity
@Table(name="typeMessage")
public class TypeMessage {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "nomTypeMessage")
	private String nomTypeMessage;
	@OneToMany(mappedBy="typeMessage", targetEntity = Ticket.class, cascade=CascadeType.ALL /*, fetch = FetchType.EAGER*/) 
    private Set<Ticket> tickets = new HashSet<Ticket>(0);
	@OneToMany(mappedBy="typeMessage", targetEntity = Message.class, cascade=CascadeType.ALL , fetch = FetchType.EAGER) 
    private Set<Message> messages = new HashSet<Message>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomTypeMessage() {
		return nomTypeMessage;
	}
	public void setNomTypeMessage(String nomTypeMessage) {
		this.nomTypeMessage = nomTypeMessage;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}
