/*package com.dar.everisdarmytasksms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dar.everisdarmytasksms.data.TaskRepository;
import com.dar.everisdarmytasksms.model.Task;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
	@InjectMocks
	private TaskService service;
	
	@Mock
	private TaskRepository repository;
	
	@Test
	public void retrieveAllItems_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(
				new Task(1,"In progress", "Backend, microservicios con Spring boot."), 
				new Task(2,"Pending" , "Repositorio Proyecto, crear repositorio público de GitHub."),
				new Task(3, "Finished", "DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.")));	
		List<Task> tasks = service.retrieveAllItems();
		assertEquals(1, tasks.get(0).getId());
		assertEquals("Pending", tasks.get(1).getTask_status());
		assertEquals("DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.", tasks.get(2).getDescription());
	}
	
}
*/