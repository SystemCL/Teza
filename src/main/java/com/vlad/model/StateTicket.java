package com.vlad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stateTicket")
public class StateTicket {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "nomStateTicket")
	private String nomStateTicket;
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "ticket_id")
    private Ticket ticket;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomStateTicket() {
		return nomStateTicket;
	}
	public void setNomStateTicket(String nomStateTicket) {
		this.nomStateTicket = nomStateTicket;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
