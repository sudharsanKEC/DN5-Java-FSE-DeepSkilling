package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws Exception{

		LOGGER.info("START- by logger");

		SpringApplication.run(SpringLearnApplication.class, args);

		displayDate();

//		displayCountry();

		displayCountries();
		LOGGER.info("END - by logger");
	}

//	public static void displayDate() throws Exception {
//
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("date-format.xml");
//
//		SimpleDateFormat format =
//				context.getBean("dateFormat", SimpleDateFormat.class);
//
//		Date date = format.parse("31/12/2018");
//
//		System.out.println(date);
//	}

	public static void displayDate() throws Exception {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format =
				context.getBean("dateFormat", SimpleDateFormat.class);

		Date date = format.parse("31/12/2018");

		LOGGER.debug("Date : {}", date);

		LOGGER.info("END");
	}

	public static void displayCountry() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		Country country =
				context.getBean("country", Country.class);


		Country anotherCountry =
				context.getBean("country", Country.class);

		System.out.println(country.getName());
		System.out.println(anotherCountry.getName());
		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country 2 : {}", anotherCountry);

		LOGGER.info("END");
	}

	@SuppressWarnings("unchecked")
	public static void displayCountries() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries =
				context.getBean("countryList", List.class);

		LOGGER.debug("Countries : {}", countries);

		LOGGER.info("END");
	}

}