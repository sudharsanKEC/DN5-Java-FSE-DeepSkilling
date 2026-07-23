package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean("bookService", BookService.class);

        service.addBook();
    }
}

/*
Exercise 1:
    We added the spring-context dependency, which provides the Spring IoC Container and related classes. In applicationContext.xml, we defined two beans: bookRepository and bookService. When we created a ClassPathXmlApplicationContext and passed it the XML configuration file, Spring read the file, created the bean objects, and started managing them inside the IoC container. Later, when we called context.getBean(), Spring returned references to those already managed bean objects. We then used those references to invoke the methods of the respective classes.



*/