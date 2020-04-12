package com.springtest.service;

import java.util.List;

import com.springtest.dto.StudentDTO;

public interface StudentService {

	List<StudentDTO> getStudentList();

	StudentDTO searchStudent(String name);

}
