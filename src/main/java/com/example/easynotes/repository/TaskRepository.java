/**
 * 
 */
package com.example.easynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Developer;
import com.example.easynotes.model.Task;

/**
 * @author Electem2
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Query(value = "SELECT t.task_id,t.NAME,t.colour_result,DATEDIFF(t.completed_date,t.created_date) AS days,t.completed_date,t.created_date,t.developer_id,t.project_id FROM task t JOIN project p ON t.project_id=p.project_id \r\n" + 
			"JOIN project_manager pm ON pm.project_manager_id=p.project_manager_id \r\n" + 
			"WHERE pm.project_manager_id = 1", nativeQuery = true)
	List<Task> findColor(Integer projectmanagerId);

}
