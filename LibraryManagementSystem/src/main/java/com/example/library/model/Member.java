package com.example.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Member {
    @Id
    @GeneratedValue
    private UUID memberid;
    private String name;
    private String email;
    private String phone;
    protected int maxBooksAllowed;

    @OneToMany
    private List<Book> currentlyIssuedBooks = new ArrayList<>();

    public abstract int getMaxAllowedDays();
    public abstract String getMemberType();
    // Getters, setters
	public UUID getMemberID() {
		return memberid;
	}
	public void setMemberID(UUID memberID) {
		this.memberid = memberID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMaxBooksAllowed() {
		return maxBooksAllowed;
	}
	public void setMaxBooksAllowed(int maxBooksAllowed) {
		this.maxBooksAllowed = maxBooksAllowed;
	}
	public List<Book> getCurrentlyIssuedBooks() {
		return currentlyIssuedBooks;
	}
	public void setCurrentlyIssuedBooks(List<Book> currentlyIssuedBooks) {
		this.currentlyIssuedBooks = currentlyIssuedBooks;
	}
}

