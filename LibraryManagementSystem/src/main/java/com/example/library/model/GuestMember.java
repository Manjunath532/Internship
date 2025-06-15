package com.example.library.model;

import jakarta.persistence.Entity;

@Entity
public class GuestMember extends Member {
    public GuestMember() { this.maxBooksAllowed = 1; }
    public int getMaxAllowedDays() { return 7; }
    public String getMemberType() { return "Guest"; }
}
