package com.restaurant.reservationApp.table;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public  class TableRepositoryImpl implements TableRepository{
    List<Table> addList = Arrays.asList(
            new Table(1,4,2),
            new Table(2,4,1),
            new Table(3,4,2),
            new Table(4,2,1),
            new Table(5,2,2),
            new Table(6,2,1),
            new Table(7,8,1)
    );
    List<Table>  deleteList = new ArrayList<>();

    public TableRepositoryImpl() {

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
