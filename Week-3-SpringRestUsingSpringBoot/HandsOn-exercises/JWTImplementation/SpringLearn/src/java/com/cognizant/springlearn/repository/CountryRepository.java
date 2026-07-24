package com.cognizant.springlearn.repository;

import com.cognizant.springlearn.model.Country;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class CountryRepository {

    public List<Country> getAllCountries() {

        try {
            XmlMapper xmlMapper = new XmlMapper();

            Countries countries = xmlMapper.readValue(
                    new ClassPathResource("country.xml").getInputStream(),
                    Countries.class);

            return countries.getCountries();

        } catch (IOException e) {
            throw new RuntimeException("Unable to load country.xml", e);
        }
    }

    // Wrapper class for parsing XML
    public static class Countries {

        @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper(useWrapping = false)
        @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(localName = "country")
        private List<Country> countries;

        public List<Country> getCountries() {
            return countries;
        }

        public void setCountries(List<Country> countries) {
            this.countries = countries;
        }
    }
}