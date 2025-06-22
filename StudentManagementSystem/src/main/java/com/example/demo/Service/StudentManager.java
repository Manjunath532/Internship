package com.example.demo.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentManager {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repository.findById(id);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        return repository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setGrade(updatedStudent.getGrade());
            student.setAddress(updatedStudent.getAddress());
            return repository.save(student);
        }).orElse(null);
    }

    public boolean deleteStudent(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}






