package com.masha.libraryapi.repository;

import com.masha.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//This replaces what would be an array list storage
//No SQL written manually

//It's a database access layer
//It communicates directly with PostgreSQL

//Because of " extends JpaRepository<Book,Long> ",
// you automatically get save(),findAll(),findById() and deleteById()
public interface Bookrepository extends JpaRepository<Book,Long> {


}
