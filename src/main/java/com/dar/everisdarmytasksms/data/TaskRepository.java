package com.dar.everisdarmytasksms.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dar.everisdarmytasksms.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}