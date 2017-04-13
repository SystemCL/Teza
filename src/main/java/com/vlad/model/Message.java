package com.vlad.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "bodyMessage")
	private String bodyMessage;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy.MM.dd")
	@Column(name = "dateCreationM")
	private Date dateCreationM;
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "ticket_id")
    private Ticket ticket;
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "typemessage_id")
    private TypeMessage typeMessage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBodyMessage() {
		return bodyMessage;
	}
	public void setBodyMessage(String bodyMessage) {
		this.bodyMessage = bodyMessage;
	}
	public Date getDateCreationM() {
		return dateCreationM;
	}
	public void setDateCreationM(Date dateCreationM) {
		this.dateCreationM = dateCreationM;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public TypeMessage getTypeMessage() {
		return typeMessage;
	}
	public void setTypeMessage(TypeMessage typeMessage) {
		this.typeMessage = typeMessage;
	}

}
