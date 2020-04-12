package com.springtest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest.dao.StudentDao;
import com.springtest.dto.StudentDTO;
import com.springtest.entity.StudentEntity;
import com.springtest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public List<StudentDTO> getStudentList() {
		List<StudentEntity> allStudents = studentDao.findAll();
		List<StudentDTO> studentDtoList  = new ArrayList<StudentDTO>();
		for (StudentEntity studentEntity : allStudents) {
			studentDtoList.add(modelMapper.map(studentEntity, StudentDTO.class));
		}
		return studentDtoList;
	}


	@Override
	public StudentDTO searchStudent(String name) {
		
		StudentEntity studentEntity = studentDao.findByStudentName(name);
		
		StudentDTO studentDTO = modelMapper.map(studentEntity, StudentDTO.class);
		
		return studentDTO;
	}

}
