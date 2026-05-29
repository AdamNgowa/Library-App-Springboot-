package com.masha.libraryapi.service;

import com.masha.libraryapi.model.Book;
import com.masha.libraryapi.repository.Bookrepository;
import org.springframework.stereotype.Service;

import java.util.List;

//This is where the actual business logic lives
//Its bad practice for controller to talk directly to the database
//Good Practice : controller -> service -> repository

@Service
public class BookService {

    private final Bookrepository repository;
    public BookService(Bookrepository repository){
        this.repository = repository;
    }

    public Book addBook(String title,String author ) {
        //Save file in repository with JpaRepository save() method
        //Instead of manual adding into arrayList
        Book book  = new Book(title,author);
        return repository.save(book);

    }

    public List<Book> getAllBooks(){
        //findAll method by JPA Repository
        //Then return results
        return repository.findAll();
    }


}
