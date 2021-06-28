package com.restaurant.reservationApp.Table;

import com.restaurant.reservationApp.Employee.Employee;

import java.util.List;

public interface TableService {
    public List<Table> getAllTable();
    public Table getTableById(long id);
    public Table createTable(Table table);
    public Table deleteTable(Table table);
}
