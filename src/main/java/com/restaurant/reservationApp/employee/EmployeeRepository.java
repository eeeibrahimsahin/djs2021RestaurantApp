package com.restaurant.reservationApp.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    Optional<Employee> findByUsername(String username);
    //Optional<Employee> findByPassword(String password);

   /* public List<Employee> getAllEmployee();
    public Employee getEmployeeById(long id);
    public Employee createEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee updateEmployee(Employee employee);*/
}
