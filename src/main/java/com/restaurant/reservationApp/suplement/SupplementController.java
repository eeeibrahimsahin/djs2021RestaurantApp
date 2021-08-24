package com.restaurant.reservationApp.suplement;


import com.restaurant.reservationApp.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SupplementController {
    @Autowired
    private SupplementService supplementService;

    @GetMapping("/supplement")
    public ResponseEntity<List<Supplement>> getAllSupplements() {
        return new ResponseEntity<>(supplementService.getAllSupplements(), HttpStatus.OK);

    }

    @GetMapping("/supplement/{id}")
    public ResponseEntity<Supplement> getSupplementById(@PathVariable(name = "id", required = true) long id) {
        Optional<Supplement> supplement = supplementService.getSupplementById(id);
        return new ResponseEntity<>(supplement.get(), HttpStatus.OK);
    }

    @GetMapping("supplement/{name}")
    public ResponseEntity<Supplement> getSupplementByName(@PathVariable(name = "name", required = true) String name) {
        Supplement supplement = SupplementService.getSupplementByName(name);
        return new ResponseEntity<>(supplement, HttpStatus.OK);
    }

    @GetMapping("/supplement_amount/{amount}")
    public ResponseEntity<List> getSupplementsLessThan(@PathVariable long amount) {

        return new ResponseEntity<>(supplementService.getSupplementsLessThan(amount), HttpStatus.OK);
    }
}
