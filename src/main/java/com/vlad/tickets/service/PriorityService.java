package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.Priority;

public interface PriorityService {
	public void addPriority(Priority priority);
	public void updatePriority(Priority priority);
	public Priority getPriority(int id);
	public void deletePriority(int id);
	public List<Priority> getPriorities();

}
