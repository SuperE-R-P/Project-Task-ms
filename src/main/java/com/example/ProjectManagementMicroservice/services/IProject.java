package com.example.ProjectManagementMicroservice.services;

import com.example.ProjectManagementMicroservice.entities.Project;

import java.util.List;


public interface IProject {
	List<Project> retrieveAllProjects();

	Project addProject(Project p);

	void deleteProject(Long id);

	Project updateProject(Project p);

	Project retrieveProject(Long id);

}
