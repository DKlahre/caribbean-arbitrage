package com.codeinvestigator.multiple_datasources.emp;


import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {

}
