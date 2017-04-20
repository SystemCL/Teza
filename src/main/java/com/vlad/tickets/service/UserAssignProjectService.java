package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.UserAssignProject;

public interface UserAssignProjectService {

	public void addUserAssignProject(UserAssignProject userAssignProject);
	public void updateUserAssignProject(UserAssignProject userAssignProject);
	public UserAssignProject getUserAssignProject(int id);
	public void deleteUserAssignProject(int id);
	public List<UserAssignProject> getUserAssignProjects();
}
