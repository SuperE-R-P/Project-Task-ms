package com.example.ProjectManagementMicroservice.controllers;

import com.example.ProjectManagementMicroservice.entities.Project;
import com.example.ProjectManagementMicroservice.entities.Task;
import com.example.ProjectManagementMicroservice.services.ProjectService;
import com.example.ProjectManagementMicroservice.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    // http://localhost:8083/SpringMVC/task/retrieve-all-tasks
    @GetMapping("/retrieve-all-tasks")
    @ResponseBody
    public List<Task> getTasks() {
        List<Task> listTasks = taskService.retrieveAllTasks();
        return listTasks;
    }


    @PostMapping("/add-task")
    @ResponseBody
    public Task addTask(@RequestBody Task p)
    {
        Task task = taskService.addTask(p);
        return task;
    }

    @DeleteMapping("/remove-task/{task-id}")
    @ResponseBody
    public void removeTask(@PathVariable("task-id") Long idTask) {
        taskService.deleteTask(idTask);
    }

    @PutMapping("/modify-task")
    @ResponseBody
    public Task modifyTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @GetMapping(value = "/tasks/name/{n}")
    public Task findByName(@PathVariable(value = "n") String name){
        return taskService.findByName(name);
    }

}
