package com.codeinvestigator.multiple_datasources.controller;
import com.codeinvestigator.multiple_datasources.emp.Employees;
import com.codeinvestigator.multiple_datasources.emp.EmployeesRepository;
import com.codeinvestigator.multiple_datasources.exception.UserNotFoundException;
import com.codeinvestigator.multiple_datasources.pass.Passengers;
import com.codeinvestigator.multiple_datasources.pass.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private PassengersRepository passengersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @PostMapping("/passenger")
    Passengers newPassenger (@RequestBody Passengers newPassenger){
        return passengersRepository.save(newPassenger);
    }

    @GetMapping("/passengers")
    List<Passengers> getAllPassengers() {
        return (List<Passengers>) passengersRepository.findAll();
    }

    @GetMapping("/passenger/{id}")
    Passengers getPassengerById(@PathVariable Integer id){
        return passengersRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping("/passenger/{id}")
    Passengers updatePassenger(@RequestBody Passengers newPassenger, @PathVariable Integer id){
        return passengersRepository.findById(id)
                .map(passenger -> {
                    passenger.setName(newPassenger.getName());
                    passenger.setPpNum(newPassenger.getPpNum());
                    passenger.setGender(newPassenger.getGender());
                    passenger.setCountry(newPassenger.getCountry());
                    passenger.setRoomNum(newPassenger.getRoomNum());
                    passenger.setCheckedIn(newPassenger.isCheckedIn());
                    return passengersRepository.save(passenger);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }


    @DeleteMapping("/passenger/{id}")
    String deletePassenger(@PathVariable Integer id){
        if(!passengersRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        passengersRepository.deleteById(id);
        return ("User with id " + id + " has been deleted successfully");
    }

    @PostMapping("/employee")
    Employees newEmployee (@RequestBody Employees newEmployee){
        return employeesRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employees> getAllEmployees() {
        return (List<Employees>) employeesRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    Employees getEmployeeById(@PathVariable Integer id){
        return employeesRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping("/employee/{id}")
    Employees updateEmployee(@RequestBody Employees newEmployee, @PathVariable Integer id){
        return employeesRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setGender(newEmployee.getGender());
                    employee.setRoomNum(newEmployee.getRoomNum());
                    employee.setJobTitle(newEmployee.getJobTitle());
                    employee.setCheckedIn(newEmployee.isCheckedIn());
                    return employeesRepository.save(employee);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Integer id){
        if(!employeesRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        employeesRepository.deleteById(id);
        return ("User with id " + id + " has been deleted successfully");
    }

}
