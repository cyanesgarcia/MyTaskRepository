/*package com.dar.everisdarmytasksms.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerIT {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/task", String.class);
		JSONAssert.assertEquals("[{\"id\":1,\"taskStatus\":\"In progress\",\"description\":\"Backend, microservicios con Spring boot.\"},"
				+ "{\"id\":2,\"taskStatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"},"
				+ "{\"id\":3,\"taskStatus\":\"Finished\",\"description\":\"DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.\"}]", response, true);
		
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]", response, false);
	}
	
	@Test
	public void contextLoadsCount() throws JSONException {
		String response = this.restTemplate.getForObject("/task/count", String.class);
		JSONAssert.assertEquals("3", response, true);
	}

}*/

