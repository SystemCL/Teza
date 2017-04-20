package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.Priority;


@Repository
public class PriorityDAOImpl implements PriorityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addPriority(Priority priority) {
		getCurrentSession().save(priority);
		
	}

	@Override
	public void updatePriority(Priority priority) {
		Priority priorityToUpdate = getPriority(priority.getId());
		priorityToUpdate.setNomPriority(priority.getNomPriority());
		//priorityToUpdate.setBitwise((priority.getBitwise()));
		//priorityToUpdate.setUserAssignPriority(priority.getUserAssignPriority());
		getCurrentSession().update(priorityToUpdate);
		
	}

	@Override
	public void deletePriority(int id) {
		Priority priority = getPriority(id);
		if(priority != null)
			getCurrentSession().delete(priority);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Priority> getPriorities() {
		return getCurrentSession().createQuery("from Priority").list();
	}

	@Override
	public Priority getPriority(int id) {
		Priority priority = (Priority) getCurrentSession().get(Priority.class, id);
		return priority;
	}

}
