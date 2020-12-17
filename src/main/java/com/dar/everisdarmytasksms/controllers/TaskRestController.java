package com.dar.everisdarmytasksms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dar.everisdarmytasksms.model.Task;
import com.dar.everisdarmytasksms.service.TaskService;

@RestController
public class TaskRestController {	
    @Autowired
    private TaskService taskService;
    
	@GetMapping("/task")
	public List<Task> retrieveAllItems() {
	    return taskService.retrieveAllItems();
	}
	
	@GetMapping("/task/count")
	public Long count() {
	    return taskService.count();
	}
	
	@GetMapping(path= "/task/status/{status}", produces = "application/json")
	public List<Task> findTaskWithState(@PathVariable String status) {
		return taskService.findTaskWithState(status);
	}
	
	@GetMapping("/task/find/{id}")
	public Optional<Task> findById(@PathVariable("id") Long id) {
	    return taskService.findById(id);
	}
	
	@DeleteMapping("/task/{id}")
	public List<Task> delete(@PathVariable int id) {
		return taskService.deleteById(id);
		
	}
	
	@PostMapping(path= "/task", produces = "application/json")
	public Task insert(Task task) {
		return taskService.saveByEntity(task);
	}
	
	@PutMapping(path= "/task", produces = "application/json")
	public Task updateTasks(Task task) {
		return taskService.updateTasks(task.getId(), task.getTask_status(), task.getDescription());
	}
	
}
