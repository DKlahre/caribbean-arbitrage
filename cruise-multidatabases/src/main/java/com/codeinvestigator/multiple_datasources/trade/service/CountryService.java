package com.codeinvestigator.multiple_datasources.trade.service;

import com.codeinvestigator.multiple_datasources.trade.Country;
import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    Country saveCountry(Country country);

    void deleteCountry(Integer id);

    Country getCountryById(Integer id);

    Country updateCountry(Country newCountry, Integer id);

}
