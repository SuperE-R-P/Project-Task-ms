package com.example.ProjectManagementMicroservice.services;

import com.example.ProjectManagementMicroservice.entities.Task;

import java.util.List;


public interface ITask {
	List<Task> retrieveAllTasks();

	Task addTask(Task t);

	void deleteTask(Long id);

	Task updateTask(Task t);

	Task retrieveTask(Long id);

}
