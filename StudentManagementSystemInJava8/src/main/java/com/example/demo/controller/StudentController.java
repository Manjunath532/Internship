package com.example.demo.controller;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@RestController

@RequestMapping("/api/students")
public class StudentController {

 @Autowired
 private StudentService studentService;


 @PostMapping
 public ResponseEntity<Student> addStudent(@RequestBody Student student) {

     Student savedStudent = studentService.saveStudent(student);
     return ResponseEntity.ok(savedStudent);
 }

 @GetMapping
 public List<Student> getAllStudents() {
     
     return studentService.getAllStudents();
 }


 @GetMapping("/{id}")
 public ResponseEntity<?> getStudentById(@PathVariable int id) {
   
     Optional<Student> student = studentService.getStudentById(id);

     if (student.isPresent()) {
      
         return ResponseEntity.ok(student.get());
     } else {
       
         return ResponseEntity.status(404).body("Student with ID " + id + " not found.");
     }
 }

 
 @PutMapping("/{id}")
 public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {

     Student updated = studentService.updateStudent(id, student);

     if (updated != null) {
    	 
         return ResponseEntity.ok(updated);
     } else {
       
         return ResponseEntity.status(404).body("Cannot update. Student with ID " + id + " not found.");
     }
 }


 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteStudent(@PathVariable int id) {
     boolean deleted = studentService.deleteStudent(id);

     if (deleted) {
        
         return ResponseEntity.ok().body("Student deleted successfully.");
     } else {
         
         return ResponseEntity.status(404).body("Cannot delete. Student with ID " + id + " not found.");
     }
 }
}

