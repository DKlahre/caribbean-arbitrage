package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.trade.Country;
import com.codeinvestigator.multiple_datasources.trade.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@AllArgsConstructor
@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getCountries() {
        return (List<Country>)countryRepository.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Integer id){
        countryRepository.deleteById(id);
    }

    @Override
    public Country getCountryById(Integer id){
        return countryRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }


    @Override
    public Country updateCountry(Country newCountry, Integer id) {

        return countryRepository.findById(id)
                .map(country -> {
                    country.setCountryName(newCountry.getCountryName());
                    country.setNatCurrency(newCountry.getNatCurrency());
                    country.setTaxRate(newCountry.getTaxRate());
                    country.setPortName(newCountry.getPortName());
                    return countryRepository.save(country);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

}
