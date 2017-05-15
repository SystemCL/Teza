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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="domainProject")
/*@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@domainId")*/
public class DomainProject {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nameDomain")
	private String nameDomain;
	
	@OneToMany( /*fetch = FetchType.EAGER,*/ mappedBy="domainProject", targetEntity = Project.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	@JsonBackReference
	private Set<Project> projects = new HashSet<Project>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameDomain() {
		return nameDomain;
	}
	public void setNameDomain(String nameDomain) {
		this.nameDomain = nameDomain;
	}
	
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	
}
