package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("\nCountries containing 'ou':");
		List<Country> countries1 = countryService.findByNameContaining("ou");
		countries1.forEach(System.out::println);

		System.out.println("\nCountries containing 'ou' (Ascending):");
		List<Country> countries2 = countryService.findByNameContainingOrderByNameAsc("ou");
		countries2.forEach(System.out::println);

		System.out.println("\nCountries starting with 'Z':");
		List<Country> countries3 = countryService.findByNameStartingWith("Z");
		countries3.forEach(System.out::println);
	}
}