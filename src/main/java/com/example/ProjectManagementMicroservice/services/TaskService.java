package com.example.ProjectManagementMicroservice.services;

import com.example.ProjectManagementMicroservice.entities.Project;
import com.example.ProjectManagementMicroservice.entities.Task;
import com.example.ProjectManagementMicroservice.repository.ProjectRepository;
import com.example.ProjectManagementMicroservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService implements ITask{

	
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Task> retrieveAllTasks() {
		List<Task> tasks = (List<Task>) taskRepository.findAll();
		return tasks;
	}

	//Ajouter un project
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void addToProject(Integer idProject, Long idTask) {
		Optional<Task> optionalTaskEntity = taskRepository.findById(idTask);
		Task task = optionalTaskEntity.get();
		Optional<Project> optionalProjectEntity = projectRepository.findById(idProject);
		Project project = optionalProjectEntity.get();
		task.setProject(project);
		taskRepository.save(task);
	}


	public Task findByName(String name) {return taskRepository.findByName(name).get(0);}



	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}


	@Override
	public Task updateTask(Task p) {
		return taskRepository.save(p);
	}

	@Override
	public Task retrieveTask(Long id) {
		Task task = taskRepository.findById(id).orElse(null);
		return task;
	}

	
}
