package com.restaurant.reservationApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    private Employee willUpdateEmployee;
    private EmployeeService employeeService;

    public EmployeeController() {
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {

        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id", required = true) long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        Employee employee1 = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable(name = "id") int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
    @PutMapping(value = "/willupdateemployee")
    public void willUpdateEmployee(@RequestBody Employee employee) {
        willUpdateEmployee =employee;
    }
    @GetMapping("/update")
    public ResponseEntity<Employee> getWillUpdateEmployee() {
        return new ResponseEntity<>(willUpdateEmployee, HttpStatus.OK);
    }
}
