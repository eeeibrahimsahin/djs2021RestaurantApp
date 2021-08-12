//package com.restaurant.reservationApp.employee;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class EmployeeRepositoryImpl implements EmployeeRepository {
//    private List<Employee> list = new ArrayList<>(Arrays.asList(
//            new Employee(1, "Aysegul", "Aydar", "aysegul.aydar", "12345"),
//            new Employee(2, "Ayse", "Kocak", "ayse.kocak", "12345"),
//            new Employee(3, "Saif", "Alamrani", "saif.alamrani", "12345"),
//            new Employee(4, "Zeynel", "Goksu", "zeynel.goksu", "12345"),
//            new Employee(5, "Issa", "Rizqallah", "issa.rizqallah", "12345"),
//            new Employee(6, "Ibrahim", "Sahin", "crazyboy007", "12345")
//    ));
//
//    public EmployeeRepositoryImpl() {
//
//    }
//
//    @Override
//    public List<Employee> getAllEmployee() {
//        return list;
//    }
//
//    @Override
//    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee1 = list.stream().filter(employee -> employee.getId() == id).findFirst();
//        return employee1.get();
//    }
//
//    @Override
//    public Employee createEmployee(Employee employee) {
//        employee.setId(list.size() + 1);
//        list.add(employee);
//        return employee;
//    }
//
//    @Override
//    public void deleteEmployee(int id) {
//        System.out.println("id = " + id);
//        final Optional<Employee> employee1 = list.stream().filter(employee -> employee.getId() == id).findFirst();
//        if (employee1.isPresent()) {
//            list.remove(employee1.get());
//        } else
//            System.out.println("There is no employee that has this id.");
//    }
//
//    @Override
//    public Employee updateEmployee(Employee employee) {
//        final Optional<Employee> willUpdateEmployee = list.stream().filter(employee1 -> employee1.getId() == employee.getId()).findFirst();
//        if (willUpdateEmployee.isPresent()) {
//            willUpdateEmployee.get().setFirstName(employee.getFirstName());
//            willUpdateEmployee.get().setLastName(employee.getLastName());
//            willUpdateEmployee.get().setUsername(employee.getUsername());
//            willUpdateEmployee.get().setPassword(employee.getPassword());
//            return willUpdateEmployee.get();
//        }
//
//        return null;
//    }
//}
