/**
 * 
 */
package com.example.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Developer;
import com.example.easynotes.service.DeveloperService;

import ch.qos.logback.core.status.Status;

/**
 * @author Electem2
 *
 */
@RestController
@RequestMapping("/projectdeveloperapi")
public class DeveloperController {
	@Autowired
	DeveloperService developerservice;

	@GetMapping("/projectManagerdeveloper")
	public Developer fetchDeveloper() {
		return developerservice.fetchDeveloper();
	}
	@GetMapping("/ProjectManagerstatus")
	public List<Developer> fetchstatus() {
		return developerservice.fetchStatus();
	}
}
