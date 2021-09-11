/**
 * 
 */
package com.example.easynotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.easynotes.model.ProjectManager;
import com.example.easynotes.service.ProjectManagerService;

/**
 * @author Electem2
 *
 */
@RestController
@RequestMapping("/projectmanagerapi")
public class ProjectManagerController {
	@Autowired
	ProjectManagerService projectmanagerservice;
	
	@GetMapping("/projectmanager/{id}")
	public ProjectManager  getProjectManagerById(@PathVariable(value = "id") Integer projectmanagerId) {
		return projectmanagerservice.fetchById(projectmanagerId);
	}
	@PostMapping("/projectManager")
	public ProjectManager createProjectManagerData(@Valid @RequestBody ProjectManager projectmanager) {
		return projectmanagerservice.save(projectmanager);
	}
	@PutMapping("/projectManager/{id}")
	public ProjectManager updateProjectManager(@PathVariable(value = "id") Integer projectmanagerId,@Valid @RequestBody ProjectManager projectmanagerDetails) {
		return projectmanagerservice.updateDataProjectManager(projectmanagerId,projectmanagerDetails);
		
	}
	
}
