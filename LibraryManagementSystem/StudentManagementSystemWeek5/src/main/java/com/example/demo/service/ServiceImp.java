package com.example.demo.service;


import com.example.demo.Entity.Student;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImp  implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

   
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

 
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    @Override
    public Optional<Student> getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
        return student;
    }

   
    @Override
    public Student updateStudent(int id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existing = optionalStudent.get();
            existing.setName(student.getName());
            existing.setGrade(student.getGrade());
            existing.setAddress(student.getAddress());
            existing.setAge(student.getAge());
           
            return studentRepository.save(existing);
        } else {
            throw new StudentNotFoundException("Cannot update. Student with ID " + id + " not found.");
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            throw new StudentNotFoundException("Cannot delete. Student with ID " + id + " does not exist.");
        }
    }
}
