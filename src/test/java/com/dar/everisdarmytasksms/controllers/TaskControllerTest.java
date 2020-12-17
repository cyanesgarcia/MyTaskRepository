package com.dar.everisdarmytasksms.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import com.dar.everisdarmytasksms.model.Task;
import com.dar.everisdarmytasksms.service.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskRestController.class)
public class TaskControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TaskService service;
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		when(service.retrieveAllItems()).thenReturn(Arrays.asList(new Task(1,"In progress", "Backend, microservicios con Spring boot."), 
				new Task(2, "Pending", "Repositorio Proyecto, crear repositorio público de GitHub."),
				new Task(3, "Finished", "DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.")));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/task").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"taskStatus\":\"In progress\",\"description\":\"Backend, microservicios con Spring boot.\"},"
						+ "{\"id\":2,\"taskStatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"},"
						+ "{\"id\":3,\"taskStatus\":\"Finished\",\"description\":\"DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.\"}]"))
				.andReturn();
	}
	
	@Test
	public void retrieveAllItems_noitems() throws Exception {
		when(service.retrieveAllItems()).thenReturn(Arrays.asList());
		
		RequestBuilder request = MockMvcRequestBuilders.get("/task").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[]"))
				.andReturn();
	}
	
	@Test
	public void count() throws Exception {
		when(service.count()).thenReturn((long) 3);
		RequestBuilder request = MockMvcRequestBuilders.get("/task/count").accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("3"))
				.andReturn();
	}
	
	@Test
	public void findTaskId() throws Exception {
		Task o = new Task(2, "Pending", "Repositorio Proyecto, crear repositorio público de GitHub.");
		when(service.findById((long)2)).thenReturn(Optional.of(o));
		RequestBuilder request = MockMvcRequestBuilders.get("/task/find/2").accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2,\"taskStatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"}"))
				.andReturn();
	}
	
	@Test
	public void findTaskWithState() throws Exception {
		when(service.findTaskWithState("Pending")).thenReturn(Arrays.asList(new Task(2, "Pending", "Repositorio Proyecto, crear repositorio público de GitHub.")));
		RequestBuilder request = MockMvcRequestBuilders.get("/task/status/Pending").accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":2,\"taskStatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"}]"))
				.andReturn();
	}
	
	@Test
	public void saveByEntity() throws Exception {
		when(service.saveByEntity(Mockito.any(Task.class))).thenReturn(new Task(4, "Pending", "Prueba"));
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
		requestParams.add("id", "4");
		requestParams.add("task_status", "Pending");
		requestParams.add("description","Prueba");
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/task")
				.params(requestParams)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{'id':4,'taskStatus':'Pending','description':'Prueba'}"))
				.andReturn();
	}
	
	
	@Test
	public void deleteById() throws Exception {
		when(service.deleteById(1)).thenReturn(Arrays.asList(new Task(4, "Pending", "Prueba")));
		RequestBuilder request = MockMvcRequestBuilders.delete("/task/{id}", 1).accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{'id':4,'taskStatus':'Pending','description':'Prueba'}]"))
				.andReturn();
	}
	
	@Test
	public void updateTasks() throws Exception {
		when(service.updateTasks(4,"Pending", "Prueba")).thenReturn(new Task(4, "Pending", "Prueba"));
		
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
		requestParams.add("id", "4");
		requestParams.add("task_status", "Pending");
		requestParams.add("description","Prueba");
		
		RequestBuilder request = MockMvcRequestBuilders.put("/task").params(requestParams)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{'id':4,'taskStatus':'Pending','description':'Prueba'}"))
				.andReturn();
	}
	
	
}