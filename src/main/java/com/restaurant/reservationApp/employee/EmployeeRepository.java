package com.restaurant.reservationApp.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
   /* public List<Employee> getAllEmployee();
    public Employee getEmployeeById(long id);
    public Employee createEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee updateEmployee(Employee employee);*/
}
