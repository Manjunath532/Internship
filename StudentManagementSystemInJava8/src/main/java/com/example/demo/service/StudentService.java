package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Optional<Student>getStudentById(int id);
	Student updateStudent(int id,Student student);
	boolean deleteStudent(int id);
}
