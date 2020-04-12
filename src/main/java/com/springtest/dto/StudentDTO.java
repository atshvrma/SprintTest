package com.springtest.dto;

public class StudentDTO {

	private String studentName;
	private String standard;
	private int totalMarks;

	public StudentDTO() {
	}
	
	public StudentDTO(String name, String standard, int totalMarks) {
		studentName = name;
		this.standard = standard;
		this.totalMarks = totalMarks;
	}
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	} 
}
