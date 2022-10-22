package com.example.ProjectManagementMicroservice.controllers;

import java.util.List;
import java.util.Set;

import com.example.ProjectManagementMicroservice.entities.Project;
import com.example.ProjectManagementMicroservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

	// http://localhost:9090/SpringMVC/project/retrieve-all-projects
		@GetMapping("/retrieve-all-projects")
		@ResponseBody
		public List<Project> getProjects() {
		List<Project> listProjects = projectService.retrieveAllProjects();
		return listProjects;
		}
		
		// http://localhost:8080/SpringMVC/servlet/retrieve-clientk/8
		@GetMapping("/retrieve-project/{project-id}")
		@ResponseBody
		public Project retrieveClient(@PathVariable("project-id") Long idProject) {
		return projectService.retrieveProject(idProject);
		}
		
		// http://localhost:9090/SpringMVC/project/add-project
		@PostMapping("/add-project")
		@ResponseBody
		public Project addProject(@RequestBody Project p)
		{
			Project project = projectService.addProject(p);
		return project;
		}
		
		// http://localhost:9090/SpringMVC/servlet/remove-project/{project-id}
		@DeleteMapping("/remove-project/{project-id}")
		@ResponseBody
		public void removeProject(@PathVariable("project-id") Long idProject) {
			projectService.deleteProject(idProject);
		}
		
		// http://localhost:9090/SpringMVC/project/modify-project
		@PutMapping("/modify-project")
		@ResponseBody
		public Project modifyProject(@RequestBody Project project) {
		return projectService.updateProject(project);
		}
    
    //http://localhost:9090/SpringMVC/project/projects/name/{n}
    @GetMapping(value = "/projects/name/{n}")
    public Project findByName(@PathVariable(value = "n") String name){
        return projectService.findByName(name);
    }

}