package com.restaurant.reservationApp.employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Long> {
    Optional<Employee> findByUsername(String username);
}
