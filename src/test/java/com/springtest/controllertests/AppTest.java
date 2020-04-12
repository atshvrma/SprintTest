package com.springtest.controllertests;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Matchers.anyString;


import com.springtest.controller.StudentController;
import com.springtest.dto.StudentDTO;
import com.springtest.service.StudentService;


@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class AppTest {

	@Autowired
	private MockMvc mockMVC;
	
	@MockBean
	private StudentService studentService;
	
	@Test
	public void test_getAllStudents_endpoint() throws Exception{
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		StudentDTO stu1 = new StudentDTO();
		studentList.add(stu1);
		studentList.add(stu1);
		studentList.add(stu1);
		
		when(studentService.getStudentList()).thenReturn(studentList);
		
		mockMVC.perform(get("/api/v1/students/getAllStudents"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$",hasSize(3) ));
	}
	
	@Test
	public void test_searchStudent_endpoint() throws Exception {
		
		when(studentService.searchStudent("Lokesh")).thenReturn(new StudentDTO("Lokesh","X",79));
		
		mockMVC.perform(get("/api/v1/students/findStudent/{name}","Lokesh"))
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.studentName").value("Lokesh"));
	}
	
	@Test
	public void test_searchStudent_endpoint_with_anyIput() throws Exception {
		
		when(studentService.searchStudent(anyString())).thenReturn(new StudentDTO("Suresh","XI",56));
		
		mockMVC.perform(get("/api/v1/students/findStudent/{name}","Lokesh"))
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$.studentName").value("Lokesh"));
	}
	
	
}
