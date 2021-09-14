/**
 * 
 */
package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.ProjectManager;

/**
 * @author Electem2
 *
 */
@Repository
public interface ProjectManagerRespository extends JpaRepository<ProjectManager, Integer>{
	@Query(value ="SELECT * FROM project_manager pm JOIN project p ON p.project_manager_id=pm.project_manager_id\r\n" + 
			  		"JOIN task t ON t.project_id = p.project_id\r\n" + 
			  		"JOIN developer d ON d.developer_id=t.developer_id\r\n" + 
			  		"JOIN status s ON s.status_id=d.status_id\r\n" + 
			  		"ORDER BY s.completed_count DESC LIMIT 1", 
			  nativeQuery = true)
	ProjectManager fetchProjectManager();
	
	
	

}
