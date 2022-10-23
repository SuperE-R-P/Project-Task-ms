package com.example.ProjectManagementMicroservice.services;

import com.example.ProjectManagementMicroservice.entities.Project;
import com.example.ProjectManagementMicroservice.entities.Task;

import java.util.List;


public interface IProject {
	List<Project> retrieveAllProjects();

	Project addProject(Project p);

	void deleteProject(Integer id);

	Project updateProject(Project p);

	Project retrieveProject(Integer id);

	List<Task> getTasks(Integer idProject);

}
