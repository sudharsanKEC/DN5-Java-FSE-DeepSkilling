package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // the method name should exactly match the bookRepository dependency, so that spring will identify it.
    // Because in the applicationContext.xml: we have <property name="bookRepository" ref="bookRepository"/>, property name = bookRepository, then spring automatically looks for the below pattern.
    /*
        Then it automatically looks for a setter whose name follows this pattern:
            set + Capitalize(first letter of property name)
                bookRepository
                    │
                    ▼
                setBookRepository()
        This is called the JavaBean naming convention.
        The Spring IoC Container calls setBookRepository() automatically while creating the BookService bean, based on the <property> configuration in applicationContext.xml.
    */
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(){
        System.out.println("BookService: Calling BookRepository...");
        bookRepository.saveBook();
    }

}