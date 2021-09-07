package com.restaurant.reservationApp.suplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SupplementController {
    @Autowired
    private SupplementService supplementService;

    @GetMapping("/supplement")
    public ResponseEntity<List> getAllSupplements() {
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

    @PostMapping("/addStock")
    public ResponseEntity<Supplement> createSupplement(@RequestBody Supplement supplement) {
        System.out.println(supplement.getFoodList());
        Supplement supplement1 = supplementService.createSupplement(supplement);
        return new  ResponseEntity<>(supplement1, HttpStatus.OK);
    }
}
