package com.example.easynotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Task;
import com.example.easynotes.service.TaskService;

@RestController
@RequestMapping("/projecttaskapi")
public class TaskController {
	@Autowired
	TaskService taskservice;


}
