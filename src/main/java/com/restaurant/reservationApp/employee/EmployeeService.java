package com.restaurant.reservationApp.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Optional<Employee> getEmployeeById(long id);

    Employee createEmployee(Employee employee);

    void saveAllEmployee(List<Employee> employeeList);

    void deleteEmployee(long id);

    Employee updateEmployee(Employee employee);

}
