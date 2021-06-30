package com.restaurant.reservationApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> list =new ArrayList<>(Arrays.asList(
            new Employee(1, "Aysegul", "Aydar", "aysegul.aydar", "12345"),
            new Employee(2, "Ayse", "Kocak", "ayse.kocak", "12345"),
            new Employee(3, "Saif", "Alamrani", "saif.alamrani", "12345"),
            new Employee(4, "Zeynel", "Goksu", "zeynel.goksu", "12345"),
            new Employee(5, "Issa", "Rizqallah", "issa.rizqallah", "12345"),
            new Employee(6, "Ibrahim", "Sahin", "crazyboy007", "12345")
            ));

    public EmployeeRepositoryImpl() {

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
        employee.setId(list.size() + 1);
        list.add(employee);
        return employee;
    }
}
