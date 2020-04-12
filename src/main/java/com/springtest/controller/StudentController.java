package com.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springtest.dto.StudentDTO;
import com.springtest.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/getAllStudents",method=RequestMethod.GET)
	public List<StudentDTO> getStudentList() {
		return  studentService.getStudentList();
	}
	
	@RequestMapping(value="/findStudent/{name}",method=RequestMethod.GET)
	public StudentDTO searchStudent(@PathVariable("name")String name) {
		return  studentService.searchStudent(name);
	}

}
