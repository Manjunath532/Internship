package com.example.library.model;

import jakarta.persistence.Entity;

@Entity
public class TeacherMember extends Member {
    public TeacherMember() { this.maxBooksAllowed = 5; }
    public int getMaxAllowedDays() { return 30; }
    public String getMemberType() { return "Teacher"; }
}
