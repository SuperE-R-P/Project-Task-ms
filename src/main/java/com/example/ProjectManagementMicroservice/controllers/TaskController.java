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
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Task> getTasks() {
        List<Task> listTasks = taskService.retrieveAllTasks();
        return listTasks;
    }


    @PostMapping("/add-task")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Task addTask(@RequestBody Task p)
    {
        Task task = taskService.addTask(p);
        return task;
    }

    @PostMapping("/affect-task/{idProject}/{idTask}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void affectTaskToProject(@PathVariable(value = "idProject") Integer idProject, @PathVariable(value = "idTask") Long idTask)
    {
        taskService.addToProject(idProject, idTask);
    }

    @DeleteMapping("/remove-task/{task-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void removeTask(@PathVariable("task-id") Long idTask) {
        taskService.deleteTask(idTask);
    }

    @PutMapping("/modify-task/{id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Task modifyTask(@RequestBody Task task,@PathVariable("id") Long id) {
        task.setTaskId(id);
        return taskService.updateTask(task);
    }

    @GetMapping(value = "/tasks/name/{n}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Task findByName(@PathVariable(value = "n") String name){
        return taskService.findByName(name);
    }


    @GetMapping(value = "/getTaskById/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Task findById(@PathVariable(value = "id") Long idTask){
        return taskService.retrieveTask(idTask);
    }
}
