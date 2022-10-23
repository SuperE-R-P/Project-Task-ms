package com.example.ProjectManagementMicroservice.services;

import java.util.List;

import com.example.ProjectManagementMicroservice.entities.Project;
import com.example.ProjectManagementMicroservice.entities.Task;
import com.example.ProjectManagementMicroservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ProjectService implements IProject{

	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	//Ajouter un project
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}
	
	
	//Mettre a jour les informations d'un project
	/*public Project updateProject(int id, Project newProject) {
		if(projectRepository.findById(id).isPresent()) {
			Project existingProject = projectRepository.findById(id).get();
			existingProject.setName(newProject.getName());
			existingProject.setDescription(newProject.getDescription());
			
			return projectRepository.save(existingProject);
		}
		else {
			return null;
		}
	}*/
	
	
	//Supprimer un project
	/*public String deleteProject(int id) {
		if(projectRepository.findById(id).isPresent()) {
			projectRepository.deleteById(id);
			return "Le project avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le project avec l'id " + id + " n'a pas ete supprime";
		}
	}*/
	
	
	
	@Override
	public List<Project> retrieveAllProjects() {
		List<Project> projects = (List<Project>) projectRepository.findAll();
		return projects;
	}

	public List<Project> getTasksByProjectId() {
		List<Project> projects = (List<Project>) projectRepository.findAll();
		return projects;
	}
	
	//Chercher un project
	/*public Project findProject(int id) {
		if(projectRepository.findById(id).isPresent()) {
			Project existingProject = projectRepository.findById(id).get();
			return existingProject;
		}
		else {
			return null;
		}
	}*/
	

    // For Test
    public Project findByName(String name) {return projectRepository.findByName(name).get(0);}


	@Override
	public void deleteProject(Integer id) {
		projectRepository.deleteById(id);	
	}


	@Override
	public Project updateProject(Project p) {
		return projectRepository.save(p);
	}


	@Override
	public Project retrieveProject(Integer id) {
		Project project = projectRepository.findById(id).orElse(null);
		return project;	
	}

	@Override
	public List<Task> getTasks(Integer idProject) {
		return null;
	}


}
