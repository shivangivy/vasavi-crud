/**
 * 
 */
package com.example.easynotes.service;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.ProjectManager;
import com.example.easynotes.repository.ProjectManagerRespository;

/**
 * @author Electem2
 *
 */
@Service
public class ProjectManagerService {
	@Autowired
	ProjectManagerRespository projectmanagerrepository;

	public ProjectManager fetchById(Integer projectmanagerId) {

		return projectmanagerrepository.findById(projectmanagerId)
				.orElseThrow(() -> new ResourceNotFoundException("ProjectManager", "id", projectmanagerId));
	}

	public ProjectManager save(@Valid ProjectManager projectmanager) {

		return projectmanagerrepository.save(projectmanager);
	}

	public ProjectManager updateDataProjectManager(Integer projectmanagerId,
			@Valid ProjectManager projectmanagerDetails) {
		ProjectManager projectmanager=projectmanagerrepository.findById(projectmanagerId).orElseThrow(() -> new ResourceNotFoundException("ProjectManager", "id", projectmanagerId));
		projectmanager.setName(projectmanagerDetails.getName());
		projectmanager.setEmailId(projectmanagerDetails.getEmailId());
		projectmanager.setCountry(projectmanagerDetails.getCountry());
		projectmanager.setProjects(projectmanagerDetails.getProjects());
		projectmanagerrepository.save(projectmanager);
		return projectmanagerDetails;
	}

}
