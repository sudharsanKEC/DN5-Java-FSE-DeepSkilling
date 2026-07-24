package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) throws CountryNotFoundException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException();
    }
}