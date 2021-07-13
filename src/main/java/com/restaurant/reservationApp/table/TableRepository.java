package com.restaurant.reservationApp.table;

import java.util.List;

public interface TableRepository {
    public List<Table> getAllTable();
    public Table getTableById(long id);

    int getNumberOfChairs(int id);

    Table getNumberOfChairs(long id);

    public Table createTable(Table table);
    public Table deleteTable(Table table);

}
