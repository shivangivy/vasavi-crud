/**
 * 
 */
package com.example.easynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Developer;

/**
 * @author Electem2
 *
 */
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
	@Query(value = "SELECT * FROM developer d JOIN status s ON s.status_id=d.status_id\r\n"
			+ "JOIN task t ON t.developer_id=t.developer_id\r\n" + "ORDER BY s.to_do_count LIMIT 1", nativeQuery = true)
	Developer fetchDeveloper();
	
	@Query(value = "SELECT d FROM Developer d join d.status")
	List<Developer> fetchStatus();
}
