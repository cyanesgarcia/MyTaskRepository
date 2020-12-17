package com.dar.everisdarmytasksms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dar.everisdarmytasksms.data.TaskRepository;
import com.dar.everisdarmytasksms.model.Task;

@Component
public class TaskService {
	@Autowired
	private TaskRepository repository;
	
	public List<Task> retrieveAllItems(){
		return repository.findAll();
	}
	
	public Long count() {
		return repository.count();
	}
	
	public Optional<Task> findById(long id) {
		return repository.findById((int) id);
	}
	
	public List<Task> findTaskWithState(String state){
		List<Task> full_list = this.retrieveAllItems();
		List<Task> partial_list = new ArrayList<Task>();
		for(Task task: full_list) {
			if(task.getTask_status().contentEquals(state)) {
				partial_list.add(task);
			}
		}
		return partial_list;
	}
	
	public Task saveByEntity(Task entity) {
		return entity !=null ? repository.save(entity) : new Task();
	}
	
	public List<Task> deleteById(int id) {
		repository.deleteById(id);
		return repository.findAll();
    }

	public Task updateTasks(int id, String task_status, String description) {
		Task task = repository.findById(id).get();
		task.setId(id);
		task.setTask_status(task_status);
		task.setDescription(description);
		return repository.save(task);
		
	}
		
}
