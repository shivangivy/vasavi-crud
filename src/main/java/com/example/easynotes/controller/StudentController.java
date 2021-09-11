/**
 * 
 */
package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Student;
import com.example.easynotes.repository.StudentRepository;

/**
 * @author Electem2
 *
 */
@RestController
@RequestMapping("/Stapi")
public class StudentController {
	@Autowired
	StudentRepository studentrepository;

	@GetMapping("/student")
	public List<Student> getAllStudent() {
		return studentrepository.findAll();
	}

	@PostMapping("/Student")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentrepository.save(student);
	}
}
