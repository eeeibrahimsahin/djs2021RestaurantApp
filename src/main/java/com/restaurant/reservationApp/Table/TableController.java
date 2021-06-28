package com.restaurant.reservationApp.Table;

import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TableController {
    TableService tableService;

    public TableController(){
    }
    @Autowired
    public TableController(TableService tableService){
        this.tableService = tableService;
    }

    @GetMapping("/tables")
    public ResponseEntity<List<Table>> getAllTable() {

        List<Table> allTable = tableService.getAllTable();
        return new ResponseEntity<>(allTable, HttpStatus.OK);
    }

    @GetMapping("/table/{id}")
    public ResponseEntity<Table> getTableById(@PathVariable(name = "id", required = true) long id) {
        Table table = tableService.getTableById(id);
        return new ResponseEntity<>(table, HttpStatus.OK);
    }

    @PutMapping(value = "/table", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Table> Table(@RequestBody Table table){
        Table table1 = tableService.createTable(table);
        return new ResponseEntity<>(table1, HttpStatus.OK);

    }
}
