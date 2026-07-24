package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

}