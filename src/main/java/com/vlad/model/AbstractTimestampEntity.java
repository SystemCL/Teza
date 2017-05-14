package com.vlad.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.Years;


@MappedSuperclass
public abstract class AbstractTimestampEntity {
	
	
	 	@Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created", nullable = false, insertable = true, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")   
	    private Date created = new Date();

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "updated", nullable = false, insertable = true, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	    private Date updated = new Date();

/*	    @Column(name = "beginninglife")
	    private String beginninglife;*/

		@PrePersist
	    protected void onCreate() {
	    	updated = created = new Date();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	    	updated = null;
	    	updated = new Date();
	    }
	    
	    protected Date getCreated(){
			return created;	
	    }
	    
	    public void setCreated(Date created) {
	    	this.created = created;
	    }
	    
/*	    @SuppressWarnings("finally")
		public String getBeginninglife() {
	    	
	    	
	    	try {
	    		beginninglife = "";
		    	
	    	    
	    			    	long time1 = created.getTime();
	    			    	long time2 = new Date().getTime() - created.getTime();
	    			    	SimpleDateFormat format =
	    			                new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
	    			    	
	    			    	Date startDate = getCreated();
	    			    	Date now = new Date();
	    		
	    		long duration  = now.getTime() - startDate.getTime();
	    		long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
	    		long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
	    		long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
	    		
	    		beginninglife = diffInHours + ":"
	    				        + diffInMinutes + ":" 
	    				        + diffInSeconds + " ";
	    		Date newD = new Date();
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
		    					+ Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 ; 
			} finally {
				return beginninglife;
			}
	    	
	    	
	    	
	    	Interval interval = new Interval(created.getTime(), dateNow);
	    	Period period = interval.toPeriod();
	    	//Date date2 = new Date(time2);
	    	beginninglife = period.getYears() 
	    			        + "-" + period.getMonths() 
	    			        + "-"+ period.getDays() + " "
	    			        + period.getHours()
	    			        + ":"+ period.getMinutes()
	    			        + ":"+ period.getSeconds();
	    	
			
		}

		public void setBeginninglife(String beginninglife) {
			 this.beginninglife = beginninglife;
		}*/


}
