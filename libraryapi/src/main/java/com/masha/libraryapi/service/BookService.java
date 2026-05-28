package com.masha.libraryapi.service;

import com.masha.libraryapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books  = new ArrayList<>();
    private int nextId = 1;

    // Function to create new book
    //Stores it in the books array list
    //And actually return the individual book
    public Book addBook(String title,String author){
        Book book = new Book(nextId++,title,author);
        books.add(book);
         return book;
    }

    //This function helps output the all the contents of the array list
    public List<Book> getAllBooks(){
        return books;
    }


}
