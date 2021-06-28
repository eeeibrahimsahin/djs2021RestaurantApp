package com.restaurant.reservationApp.Table;
import com.restaurant.reservationApp.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public  class TableRepositoryImpl implements TableRepository{
    List<Table> addList = new ArrayList<>();
    List<Table>  deleteList = new ArrayList<>();

    public TableRepositoryImpl() {
        Table table = new Table();
        table.setId(3);
        table.setNumberOfChairs(5);
        addList.add(table);

    }

    @Override
    public Table getTableById(long id) {
        Table table = addList.stream().filter(table1 -> table1.getId()==id).findFirst().get();
        return table;
    }

    @Override
    public List<Table> getAllTable() {
        return addList;
    }

    @Override
    public  int getNumberOfChairs(int id) {
        Table table = addList.stream().filter(table1 -> table1.getId()==id).findFirst().get();
        return table.getNumberOfChairs();
    }

    @Override
    public Table getNumberOfChairs(long id) {
        Optional<Table> table1 = addList.stream().filter(table -> table.getId() == id).findFirst();
        return table1.get();
    }

    @Override
    public Table createTable(Table table) {
        table.setId(addList.size()+1);
        addList.add(table);
        return table;
    }

    @Override
    public Table deleteTable(Table table) {
        table.setId(deleteList.size()+1);
        deleteList.add(table);
        table.setId(addList.size()-1);
        return table;
    }

}
