package com.restaurant.reservationApp.table;

import java.util.List;
import java.util.Optional;

public interface TableService {
    public List<Table> getAllTable();
    public Optional<Table> getTableById(long id);
    public Table createTable(Table table);
    public void deleteTable(Table table);

}
