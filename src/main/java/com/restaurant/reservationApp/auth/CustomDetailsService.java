package com.restaurant.reservationApp.auth;

import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeRepository;
import com.restaurant.reservationApp.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        System.out.println("employee = " + employee);
        if (employee.isPresent()) {
            System.out.println("employee = " + employee);
            return new CustomUserDetails(employee.get());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
