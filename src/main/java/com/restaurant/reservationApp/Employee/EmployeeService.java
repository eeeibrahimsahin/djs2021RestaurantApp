package com.restaurant.reservationApp.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(long id);
    public Employee createEmployee(Employee employee);
}
