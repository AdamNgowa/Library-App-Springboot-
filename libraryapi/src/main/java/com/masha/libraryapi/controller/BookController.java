package com.masha.libraryapi.controller;

import com.masha.libraryapi.model.Book;
import com.masha.libraryapi.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book addBook(@RequestParam String title,
                        @RequestParam String author) {
        return service.addBook(title, author);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
}