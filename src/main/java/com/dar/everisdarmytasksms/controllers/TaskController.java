package com.dar.everisdarmytasksms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dar.everisdarmytasksms.service.TaskService;


@Controller
public class TaskController {		
	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String retrieveAllItems(Model model) {
		 model.addAttribute("lista", taskService.retrieveAllItems());
		 return "index";
	}
}