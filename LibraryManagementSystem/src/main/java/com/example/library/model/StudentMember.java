package com.example.library.model;

import jakarta.persistence.Entity;

@Entity
public class StudentMember extends Member {
    public StudentMember() { this.maxBooksAllowed = 3; }
    public int getMaxAllowedDays() { return 14; }
    public String getMemberType() { return "Student"; }
}
