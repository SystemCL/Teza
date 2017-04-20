package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.Priority;
import com.vlad.tickets.dao.PriorityDAO;

@Service(value="priorityDAO")
@Transactional
public class PriorityServiceImpl implements PriorityService{
	@Autowired
	private PriorityDAO priorityDAO;
	
	@Override
	public void addPriority(Priority priority) {
		priorityDAO.addPriority(priority);
		
	}

	@Override
	public void updatePriority(Priority priority) {
		priorityDAO.updatePriority(priority);
		
	}

	@Override
	public Priority getPriority(int id) {
		return priorityDAO.getPriority(id);
		
	}

	@Override
	public void deletePriority(int id) {
		priorityDAO.deletePriority(id);
		
	}
	
	@Override
	public List<Priority> getPriorities() {
		return priorityDAO.getPriorities();
		
	}

}
