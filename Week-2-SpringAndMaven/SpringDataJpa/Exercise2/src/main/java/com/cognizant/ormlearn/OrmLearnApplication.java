package com.cognizant.ormlearn;

import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private StockRepository stockRepository;


	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Facebook September 2019");

		stockRepository.findByCodeAndDateBetween(
						"FB",
						LocalDate.of(2019,9,1),
						LocalDate.of(2019,9,30))
				.forEach(System.out::println);

		System.out.println("\nGoogle Close > 1250");

		stockRepository.findByCodeAndCloseGreaterThan(
						"GOOGL",
						1250)
				.forEach(System.out::println);

		System.out.println("\nTop 3 Volume");

		stockRepository.findTop3ByOrderByVolumeDesc()
				.forEach(System.out::println);

		System.out.println("\nLowest 3 Netflix");

		stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
				.forEach(System.out::println);
	}
}