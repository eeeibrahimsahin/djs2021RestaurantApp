package com.restaurant.reservationApp.Table;
import com.restaurant.reservationApp.Employee.Employee;
import com.restaurant.reservationApp.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService{
    TableRepository tableRepository;

    public TableServiceImpl() {
    }

    @Autowired
    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public List<Table> getAllTable() {

        return tableRepository.getAllTable();
    }

    @Override
    public Table getTableById(long id) {
        return tableRepository.getTableById(id);
    }

    @Override
    public Table createTable(Table table) {
        return tableRepository.createTable(table);
    }

    @Override
    public Table deleteTable(Table table) {
        return tableRepository.deleteTable(table);
    }
}



