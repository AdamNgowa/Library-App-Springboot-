package com.masha.libraryapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

//Book model is used as a blueprint for a real world object
//This specific model is a blueprint for a book
//It's a java object and a database table row

//One 'Book object' maps to one row in a database

//@Entity tells Hibernate ORM : "This class should become a database table"
//We use @Entity to make a the class a database
@Entity
//Sets database table name.
// Without it, Spring would likely create a database called "book" Instead of "books"

@Table(name="books")

public class Book{
    //Primary key . unique identifier for each book
    @Id
   // Tells PostgreSQL:"Automatically generate IDs"
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    //Input validation
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Author cannot be empty")
    private String author;

    public Book(){}

    public Book(String title,String author){
        this.title = title;
        this.author = author;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
         this.author = author;
    }




}

