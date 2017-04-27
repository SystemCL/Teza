package com.vlad.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;


@MappedSuperclass
public abstract class AbstractTimestampEntity {
	
	 	@Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created", nullable = false, insertable = true, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")   
	    private Date created = new Date();

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "updated", nullable = false, insertable = true, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	    private Date updated;

	    @Column(name = "beginninglife")
	    private String beginninglife;

		@PrePersist
	    protected void onCreate() {
	    	updated = created = new Date();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	    	updated = null;
	    	updated = new Date();
	    }
	    
	    public String getBeginninglife() {
	    	beginninglife = "";
	    	
	    
/*	    	long time1 = created.getTime();
	    	long time2 = new Date().getTime() - created.getTime();*/
	    	/*SimpleDateFormat simpleDateFormat =
	                new SimpleDateFormat("dd/M/yyyy hh:mm:ss");*/
	    /*	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");*/
	    	long dateNow;
	    	dateNow = System.currentTimeMillis();
	    	Interval interval = new Interval(created.getTime(), dateNow);
	    	Period period = interval.toPeriod();
	    	//Date date2 = new Date(time2);
	    	beginninglife = period.getYears() 
	    			        + "-" + period.getMonths() 
	    			        + "-"+ period.getDays() + " "
	    			        + period.getHours()
	    			        + ":"+ period.getMinutes()
	    			        + ":"+ period.getSeconds();
	    	
			return beginninglife;
		}

		public void setBeginninglife(String beginninglife) {
			this.beginninglife = beginninglife;
		}


}
