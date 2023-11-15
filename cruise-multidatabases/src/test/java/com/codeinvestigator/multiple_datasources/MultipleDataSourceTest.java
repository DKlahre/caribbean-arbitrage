package com.codeinvestigator.multiple_datasources;

import com.codeinvestigator.multiple_datasources.emp.Employees;
import com.codeinvestigator.multiple_datasources.emp.EmployeesRepository;
import com.codeinvestigator.multiple_datasources.pass.Passengers;
import com.codeinvestigator.multiple_datasources.pass.PassengersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MultipleDataSourceTest {




    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    PassengersRepository passengersRepository;

    @Disabled
    @Test
    void testRepo(){

        employeesRepository.deleteAll();
        passengersRepository.deleteAll();

        employeesRepository.save(Employees.of("Reinhard", "male", "254", "cook", false));
        employeesRepository.save(Employees.of("Sally", "female", "165", "housekeeper", true));

        passengersRepository.save(Passengers.of("Daniel", "YT748566645", "female", "Ukraine", "257", true));
        passengersRepository.save(Passengers.of("Fester", "PS664646945", "male", "Romania", "114", false));

        long countPassengers = passengersRepository.count();
        long countEmployees = employeesRepository.count();

        Assertions.assertEquals(countPassengers, 2);
        Assertions.assertEquals(countEmployees, 2);
    }
}
