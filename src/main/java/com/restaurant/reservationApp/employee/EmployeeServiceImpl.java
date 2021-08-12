package com.restaurant.reservationApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
    }
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    @Override
    public List<Employee> getAllEmployee() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> result = new ArrayList<>();
        employees.forEach(result::add);
        return result;
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
      return employeeRepository.findById(id);

    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            Optional<Employee> employee1 = employeeRepository.findById(employee.getId());
            employee1.get().setFirstName(employee.getFirstName());
            employee1.get().setLastName(employee.getLastName());
            employee1.get().setUsername(employee.getUsername());
            employee1.get().setPassword(employee.getPassword());
            employeeRepository.save(employee1.get());
            return employee1.get();
        }
        return null; // //TO DO: We should handle to return null situation
    }
}
