package com.vlad.model;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.springframework.format.annotation.DateTimeFormat;

import com.vlad.model.Ticket;

@Entity
@Indexed
@Table(name="project")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Project extends AbstractTimestampEntity {
	@Id
	@GeneratedValue
	private Integer id;
	@Field(store = Store.NO)
	@Column(name = "nomProject")
	private String nomProject;
	@ManyToOne(/*fetch = FetchType.EAGER*/)
	@JoinColumn(name = "domain_id")
    private DomainProject domainProject;
	@Column(name = "dateCreationP", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date dateCreationP;
    @Column(name = "beginninglife1")
    private String beginninglife1;

	/*	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy.MM.dd")
	@Column(name = "dateCreationP")
	private Date dateCreationP;*/
	@OneToMany( /*fetch = FetchType.EAGER,*/ mappedBy="project", targetEntity = Ticket.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	private Set<Ticket> tickets = new HashSet<Ticket>(0);
	@OneToMany( /*fetch = FetchType.EAGER,*/ mappedBy="project", targetEntity = UserAssignProject.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
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
