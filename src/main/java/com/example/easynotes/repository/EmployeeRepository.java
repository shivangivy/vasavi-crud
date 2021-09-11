/**
 * 
 */
package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Employee;

/**
 * @author Electem2
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
