package com.example.library.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.repository.BookRepository;
import com.example.library.repository.MemberRepository;




@Service
public class LibraryService {
    @Autowired BookRepository bookRepo;
    @Autowired MemberRepository memberRepo;

    public void issueBook(UUID bookId, UUID memberId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        Member member = memberRepo.findById(memberId).orElseThrow();

        if (book.isIssued()) throw new RuntimeException("Book already issued.");
        if (member.getCurrentlyIssuedBooks().size() >= member.getMaxBooksAllowed())
            throw new RuntimeException("Limit reached.");

        book.setIssued(true);
        book.setIssuedTo((java.lang.reflect.Member) member);
        book.setDueDate(LocalDate.now().plusDays(member.getMaxAllowedDays()));
        member.getCurrentlyIssuedBooks().add(book);

        bookRepo.save(book);
        memberRepo.save(member);
    }

    public void returnBook(UUID bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        Member member = (Member) book.getIssuedTo();

        book.setIssued(false);
        book.setIssuedTo(null);
        book.setDueDate(null);
        member.getCurrentlyIssuedBooks().remove(book);

        if (!book.getReservationQueue().isEmpty()) {
            java.lang.reflect.Member next = book.getReservationQueue().poll();
            issueBook(book.getBookID(), ((Member) next).getMemberID());
        }

        bookRepo.save(book);
        memberRepo.save(member);
    }

    

    public void reserveBook(UUID bookId, UUID memberId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        Member member = memberRepo.findById(memberId).orElseThrow();

        if (!book.isIssued()) throw new RuntimeException("Book is available; no need to reserve.");
        book.getReservationQueue().add((java.lang.reflect.Member) member);
        bookRepo.save(book);
    }

    public void registerMember(Member member) {
        if (memberRepo.existsByEmailOrPhone(member.getEmail(), member.getPhone()))
            throw new RuntimeException("Member already exists.");
        memberRepo.save(member);
    }

    public List<Book> viewOverdueBooks() {
        return bookRepo.findAll().stream()
            .filter(b -> b.getDueDate() != null && b.getDueDate().isBefore(LocalDate.now()))
            .collect(Collectors.toList());
    }

    public Book getBookById(UUID book_Id) {
        return bookRepo.findById(book_Id)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + book_Id));
    }
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

   
	
	}




