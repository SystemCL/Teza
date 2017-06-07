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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="userAssignProject")
public class UserAssignProject {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy.MM.dd")
	@Column(name = "dateCreationUserAssignProject", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date dateCreationUserAssignProject;
	
	@OneToMany( /*fetch = FetchType.EAGER,*/ mappedBy="userAssignProject", targetEntity = Permission.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	@JsonBackReference
	private Set<Permission> permissions;
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "utilisateur_id")
	@JsonManagedReference
	private Utilisateur utilisateur;
	
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "project_id")
	@JsonManagedReference
    private Project project;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateCreationUserAssignProject() {
		return dateCreationUserAssignProject;
	}
	public void setDateCreationUserAssignProject(Date dateCreationUserAssignProject) {
		this.dateCreationUserAssignProject = dateCreationUserAssignProject;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
