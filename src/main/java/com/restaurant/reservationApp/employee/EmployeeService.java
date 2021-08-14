package com.restaurant.reservationApp.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Optional<Employee> getEmployeeById(long id);

    public Employee createEmployee(Employee employee);

    void deleteEmployee(long id);

    Employee updateEmployee(Employee employee);

}
