/**
 * 
 */
package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.ProjectManager;

/**
 * @author Electem2
 *
 */
@Repository
public interface ProjectManagerRespository extends JpaRepository<ProjectManager, Integer>{

}
