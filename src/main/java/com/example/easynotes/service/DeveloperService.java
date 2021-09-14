/**
 * 
 */
package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.model.Developer;
import com.example.easynotes.repository.DeveloperRepository;

import ch.qos.logback.core.status.Status;

/**
 * @author Electem2
 *
 */
@Service
public class DeveloperService {
	@Autowired
	DeveloperRepository developerrepository;

	public Developer fetchDeveloper() {

		return developerrepository.fetchDeveloper();
	}

	public List<Developer> fetchStatus() {
		return developerrepository.fetchStatus();
	}
}
