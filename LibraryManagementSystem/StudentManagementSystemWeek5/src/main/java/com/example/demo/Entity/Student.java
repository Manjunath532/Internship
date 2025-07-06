package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "students") // Optional: to define table name explicitly
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @NotBlank
    @Column(name = "student_name")
    private String name;

    @Min(value = 1, message = "Age must be positive")
    @Column(name = "student_age")
    private int age;

    @Pattern(regexp = "^(A\\+|A|B\\+|B|C\\+|C|D|F)$", message = "Grade format invalid")
    @Column(name = "grade")
    private String grade;

    @Column(name = "address")
    private String address;

    // ✅ No-arg constructor (required by JPA)
    public Student() {
    }

    // ✅ All-args constructor (optional, helpful for creating objects)
    public Student(int id, String name, int age, String grade, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.address = address;
    }

    // ✅ Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
