package com.restaurant.reservationApp.table;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TableRepository extends CrudRepository<Table,Long> {
//    public List<Table> getAllTable();
//    public Table getTableById(long id);
//
//    int getNumberOfChairs(int id);
//
//    Table getNumberOfChairs(long id);
//
//    public Table createTable(Table table);
//    public Table deleteTable(Table table);

}
