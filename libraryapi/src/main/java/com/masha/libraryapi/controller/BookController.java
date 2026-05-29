package com.masha.libraryapi.controller;

import com.masha.libraryapi.model.Book;
import com.masha.libraryapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //@POST Mapping means the code below handles POST Requests
    //Instead of just returning data(Spring Boot -> Book JSON),
    //You now return Spring Boot → Book JSON + HTTP 201 CREATED
    //This is REST best practice

    @PostMapping
    //@Valid allows for You get automatic error response.
    //In case of empty values
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        Book savedBook = service.addBook(book);
        return new ResponseEntity<>(savedBook,HttpStatus.CREATED);
    }
    //Means the code below handles GET Requests
    //    Spring automatically:
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