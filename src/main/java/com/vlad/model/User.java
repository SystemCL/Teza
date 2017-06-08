package com.vlad.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	private String username;
	private String password;
	private boolean enabled;
	@JsonBackReference
	//  @OneToMany( cascade=CascadeType.REMOVE, mappedBy="project", targetEntity = Ticket.class, fetch=FetchType.LAZY, orphanRemoval = true) 
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="user", targetEntity = UserRole.class, fetch=FetchType.EAGER, orphanRemoval = true) 
	private Set<UserRole> userRole;
	@OneToOne(mappedBy="user",cascade=CascadeType.REMOVE,  fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Utilisateur.class)
	@JoinColumn(name="userUtilisateur")
	@JsonManagedReference
    private Utilisateur userUtilisateur;


	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public User(Integer id, String username, String password, boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password,
		boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@Column(name = "username", unique = true,
		nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password",
		nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Utilisateur getUserUtilisateur() {
		return userUtilisateur;
	}

	public void setUserUtilisateur(Utilisateur userUtilisateur) {
		this.userUtilisateur = userUtilisateur;
	}


}