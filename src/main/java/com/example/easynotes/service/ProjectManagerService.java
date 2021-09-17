/**
 * 
 */
package com.example.easynotes.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.ProjectManager;
import com.example.easynotes.model.Task;
import com.example.easynotes.repository.ProjectManagerRespository;
import com.example.easynotes.repository.TaskRepository;

/**
 * @author Electem2
 *
 */
@Service
public class ProjectManagerService {
	@Autowired
	ProjectManagerRespository projectmanagerrepository;
	
	@Autowired
	TaskRepository taskRepository;

	public ProjectManager fetchById(Integer projectmanagerId) {

		return projectmanagerrepository.findById(projectmanagerId)
				.orElseThrow(() -> new ResourceNotFoundException("ProjectManager", "id", projectmanagerId));
	}

	public ProjectManager save(@Valid ProjectManager projectmanager) {

		return projectmanagerrepository.save(projectmanager);
	}

	public ProjectManager updateDataProjectManager(Integer projectmanagerId,
			@Valid ProjectManager projectmanagerDetails) {
		ProjectManager projectmanager = projectmanagerrepository.findById(projectmanagerId)
				.orElseThrow(() -> new ResourceNotFoundException("ProjectManager", "id", projectmanagerId));
		projectmanager.setName(projectmanagerDetails.getName());
		projectmanager.setEmailId(projectmanagerDetails.getEmailId());
		projectmanager.setCountry(projectmanagerDetails.getCountry());
		projectmanager.setProjects(projectmanagerDetails.getProjects());
		projectmanagerrepository.save(projectmanager);
		return projectmanagerDetails;
	}

	public ProjectManager fetchProjectManagerId() {

		return projectmanagerrepository.fetchProjectManager();
	}

	public List<Task> findColor(Integer projectmanagerId) {
		List<Task> tasks = taskRepository.findColor(projectmanagerId);
		for (Task task : tasks) {
			int num = (task.getDays() > 0) && (task.getDays() < 3) ? 1 : -1;
			num = (task.getDays() > 3) && (task.getDays() < 7) ? 2 : num;
			num = (task.getDays() > 7) && (task.getDays() < 15) ? 3 : num;
			num = (task.getDays() > 15) && (task.getDays() < 30) ? 4 : num;
			switch (num) {
			case 1:
				task.setColourResult("red");
				break;
			case 2:
				task.setColourResult("orange");
				break;
			case 3:
				task.setColourResult("yellow");
				break;
			case 4:
				task.setColourResult("green");
				break;
			default:
				task.setColourResult("green");
				break;
			}
			taskRepository.save(task);
		}

		return tasks;
	}
	

}
