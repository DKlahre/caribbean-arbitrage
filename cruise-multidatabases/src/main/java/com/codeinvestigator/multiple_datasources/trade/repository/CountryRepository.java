package com.codeinvestigator.multiple_datasources.trade.repository;

import com.codeinvestigator.multiple_datasources.trade.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

}
