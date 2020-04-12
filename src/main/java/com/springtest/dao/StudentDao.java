package com.springtest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtest.entity.StudentEntity;

@Repository
public interface StudentDao  extends JpaRepository<StudentEntity, String> {

	StudentEntity findByStudentName(String name);

}
