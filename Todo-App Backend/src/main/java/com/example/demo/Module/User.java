package com.example.demo.Module;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "fullname")
  private String fullName;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  // ✅ No-args constructor required by JPA
  public User() {
  }

  // All-args constructor
  public User(Long id, String fullName, String email, String password) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.password = password;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
