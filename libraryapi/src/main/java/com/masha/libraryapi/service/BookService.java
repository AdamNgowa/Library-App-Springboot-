package com.masha.libraryapi.service;

import com.masha.libraryapi.exception.BookNotFoundException;
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

    public Book getBookById(Long id){
        return repository.findById(id).orElseThrow(()->new BookNotFoundException("Book with id"+id+"not found"));
    }

    public Book addBook(Book book ) {
        //Save file in repository with JpaRepository save() method
        //Instead of manual adding into arrayList
       return repository.save(book);

    }



    public List<Book> getAllBooks(){
        //findAll method by JPA Repository
        //Then return results
        return repository.findAll();
    }


}
