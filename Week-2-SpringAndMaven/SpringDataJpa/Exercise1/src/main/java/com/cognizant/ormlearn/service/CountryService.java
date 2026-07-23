package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findByNameContaining(String text) {
        return countryRepository.findByNameContaining(text);
    }

    public List<Country> findByNameContainingOrderByNameAsc(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    public List<Country> findByNameStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }
}