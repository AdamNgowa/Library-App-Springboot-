package com.masha.libraryapi.controller;

import com.masha.libraryapi.model.Book;
import com.masha.libraryapi.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The controller is like front desk reception
//it doesn't handle business logic,
//Instead it sends you to the service,which actually handles the business logic
//E.g service.addBook() -> means the actual function is in the service and the controller function sends you there


//@RestController tells spring this class handles REST Api requests
@RestController

//Rest is a standardized way of exposing your app's functionality through URLs


//Means all routes begin with /books
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    //Means the code below handles POST Requests
    @PostMapping
    public Book addBook(@RequestParam String title,
                        @RequestParam String author) {
        return service.addBook(title, author);
    }

    //Means the code below handles GET Requests
//    Spring automatically:
//
//    receives HTTP request
//    converts data to Java objects
//    converts Java objects to JSON
//    sends HTTP response
//    That automatic conversion is one reason Spring Boot is powerful.
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
}