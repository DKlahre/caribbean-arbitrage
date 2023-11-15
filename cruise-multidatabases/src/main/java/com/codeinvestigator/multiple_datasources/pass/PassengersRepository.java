package com.codeinvestigator.multiple_datasources.pass;

import org.springframework.data.repository.CrudRepository;

public interface PassengersRepository extends CrudRepository<Passengers, Integer> {
}
