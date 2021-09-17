/**
 * 
 */
package com.example.easynotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.model.Task;
import com.example.easynotes.repository.TaskRepository;

/**
 * @author Electem2
 *
 */
@Service
public class TaskService {
	@Autowired
	TaskRepository taskrepository;

	

	
}
