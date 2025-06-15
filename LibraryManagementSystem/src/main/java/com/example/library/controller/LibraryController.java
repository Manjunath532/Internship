package com.example.library.controller;
import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.service.LibraryService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("library_db")
public class LibraryController {
    @Autowired LibraryService service;
    
    @GetMapping("/books/{book_Id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID book_Id) {
        Book book = service.getBookById(book_Id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return service.getAllMembers();
    }


    @PostMapping("/issue/{bookId}/{memberId}")
    public ResponseEntity<String> issueBook(@PathVariable UUID bookId, @PathVariable UUID memberId) {
        service.issueBook(bookId, memberId);
        return ResponseEntity.ok("Book issued.");
    }

    @PostMapping("/return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable UUID bookId) {
        service.returnBook(bookId);
        return ResponseEntity.ok("Book returned.");
    }

    

    @PostMapping("/reserve/{bookId}/{memberId}")
    public ResponseEntity<String> reserveBook(@PathVariable UUID bookId, @PathVariable UUID memberId) {
        service.reserveBook(bookId, memberId);
        return ResponseEntity.ok("Book reserved.");
    }

    @GetMapping("/overdue")
    public List<Book> viewOverdueBooks() {
        return service.viewOverdueBooks();
    }
}