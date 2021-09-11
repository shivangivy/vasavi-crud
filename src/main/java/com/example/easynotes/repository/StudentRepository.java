/**
 * 
 */
package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Student;

/**
 * @author Electem2
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
