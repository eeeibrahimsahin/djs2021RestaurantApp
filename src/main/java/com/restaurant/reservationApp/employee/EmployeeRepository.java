package com.restaurant.reservationApp.employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(long id);
    public Employee createEmployee(Employee employee);
}
