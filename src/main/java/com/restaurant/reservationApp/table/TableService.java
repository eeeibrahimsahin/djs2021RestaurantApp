package com.restaurant.reservationApp.table;

import java.util.List;
import java.util.Optional;

public interface TableService {
    List<Table> getAllTable();

    Optional<Table> getTableById(long id);

    Table createTable(Table table);

    void saveAllTable(List<Table> tableList);

    void deleteTable(Table table);

}
