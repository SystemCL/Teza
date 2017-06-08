package com.vlad.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlad.model.Ticket;

@Entity
@Table(name="project")
//@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility=Visibility.NONE)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="project")
/*@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@projectId")*/
public class Project extends AbstractTimestampEntity {
	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Integer id;
	
	//@Field(store = Store.NO, index=Index.YES)
	@Column(name = "nomProject")
	@JsonProperty("nomProject")
	private String nomProject;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "domain_id")
	@JsonProperty("domainProject")
	@JsonManagedReference
    private DomainProject domainProject;
	
	@Column(name = "dateCreationP", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	@JsonProperty("dateCreationP")
	private Date dateCreationP;
	
    @Column(name = "beginninglife1")
    @JsonProperty("beginninglife1")
    private String beginninglife1;
    
    @OneToMany( cascade=CascadeType.REMOVE, mappedBy="project", targetEntity = Ticket.class, fetch=FetchType.LAZY, orphanRemoval = true) 
    @JsonBackReference
    private Set<Ticket> tickets = new HashSet<Ticket>(0);
    
    @OneToMany( cascade=CascadeType.REMOVE, mappedBy="project", targetEntity = UserAssignProject.class, fetch = FetchType.LAZY, orphanRemoval = true) 
    @JsonBackReference
    private Set<UserAssignProject> userAssignProjects = new HashSet<UserAssignProject>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomProject() {
		return nomProject;
	}
	public void setNomProject(String nomProject) {
		this.nomProject = nomProject;
	}
	
	public Date getDateCreationP() {
		return dateCreationP;
	}
	public void setDateCreationP(Date dateCreationP) {
		this.dateCreationP = dateCreationP;
	}
	
	public String getBeginninglife1() {
		beginninglife1 = "";
		
		
		/*	    	long time1 = created.getTime();
			    	long time2 = new Date().getTime() - created.getTime();*/
			    	SimpleDateFormat format =
			                new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
			    	
			    	Date startDate = dateCreationP;
			    	Date now = new Date();
		
		long duration  = now.getTime() - startDate.getTime();
		long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
		
		beginninglife1 = diffInHours + ":"
				        + diffInMinutes + ":" 
				        + diffInSeconds + " ";
		/*Date newD = new Date();
		String str = format.format(getCreated());
		String str1 = format.format(newD);
		startDate = format.parse(str);
		now = format.parse(str1);
		
		DateTime dt1 = new DateTime(startDate);
		DateTime dt2 = new DateTime(now);
		
		beginninglife = Years.yearsBetween(dt1, dt2).getYears() + "-" 
						+ Months.monthsBetween(dt1, dt2).getMonths() + "-"
						+ Days.daysBetween(dt1, dt2).getDays() + " "
						+ Hours.hoursBetween(dt1, dt2).getHours() % 24 + ":"
						+ Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + ":"
						+ Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 ; */
		return beginninglife1;
		
	}
	public void setBeginninglife1(String beginninglife1) {
		this.beginninglife1 = beginninglife1;
	}
	
	public DomainProject getDomainProject() {
		return domainProject;
	}
	public void setDomainProject(DomainProject domainProject) {
		this.domainProject = domainProject;
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
	
	
	public Set<Ticket> tickets(Set<Ticket> tickets){
		this.tickets = tickets;
		return tickets;
	}
	
	public Set<UserAssignProject> userAssignProjects(Set<UserAssignProject> userAssignProjects){
		this.userAssignProjects = userAssignProjects;
		return userAssignProjects;
	}
	
	
	
}
