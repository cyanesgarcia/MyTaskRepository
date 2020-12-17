package com.dar.everisdarmytasksms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonProperty("taskStatus")
	@Column(name="task_status", length=250, nullable=true, unique=false)
	private String task_status;
	
	@Column(name="description", length=256, nullable=true, unique=false)
	private String description;
	

	public Task() {}
	
	public Task(int id, String task_status, String description) {
		this.id = id;
		this.task_status = task_status;
		this.description = description;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTask_status() {
		return task_status;
	}
	
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return String.format("[%d, %s, %s]", id, task_status, description);
	}
}
