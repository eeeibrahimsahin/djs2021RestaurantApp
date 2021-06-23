package com.restaurant.reservationApp.Employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    List<Employee> list = new ArrayList<>();

    public EmployeeRepositoryImpl() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Ibrahim");
        list.add(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return list;
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee1 = list.stream().filter(employee -> employee.getId() == id).findFirst();
        return employee1.get();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(list.size()+1);
        list.add(employee);
        return employee;
    }
}
