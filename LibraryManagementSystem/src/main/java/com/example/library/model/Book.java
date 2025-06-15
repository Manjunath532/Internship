package com.example.library.model;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class Book {
    @Id
    @GeneratedValue
    private UUID bookID;
    private String title;
    private String author;
    private String genre;
    private boolean isIssued = false;

    @ManyToOne
    private Member issuedTo;

    public UUID getBookID() {
		return bookID;
	}

	public void setBookID(UUID bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public Member getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(Member issuedTo) {
		this.issuedTo = issuedTo;
	}

	public Book(UUID bookID, String title, String author, String genre, boolean isIssued, Member issuedTo,
			LocalDate dueDate, Queue<Member> reservationQueue) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isIssued = isIssued;
		this.issuedTo = issuedTo;
		this.dueDate = dueDate;
		this.reservationQueue = reservationQueue;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Queue<Member> getReservationQueue() {
		return reservationQueue;
	}

	public void setReservationQueue(Queue<Member> reservationQueue) {
		this.reservationQueue = reservationQueue;
	}

	private LocalDate dueDate;

    @ManyToMany
    private Queue<Member> reservationQueue = new LinkedList<>();
    

	
}
