package com.springtest.serviceTests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springtest.dao.StudentDao;
import com.springtest.dto.StudentDTO;
import com.springtest.entity.StudentEntity;
import com.springtest.service.StudentService;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTests {

	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private StudentDao studentDao;
	
	@Test
	public void getStudentList_tests() {
		List<StudentDTO> studentList = studentService.getStudentList();
		assertEquals(studentList.size(), 3);
	}

	@Test
	public void searchStudent_tests(){
		StudentEntity studentEntity = studentDao.findByStudentName("Lokesh Gupta");
		assertEquals(studentEntity.getStudentName(), "Lokesh Gupta");
	}
	
}
