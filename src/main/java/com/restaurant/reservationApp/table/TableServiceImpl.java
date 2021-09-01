package com.restaurant.reservationApp.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableRepository tableRepository;


    @Override
    public List<Table> getAllTable() {
        List<Table> tables = new ArrayList<>();
        Iterable<Table> tableIterable = tableRepository.findAll();
        tableIterable.forEach(tables::add);
        return tables;
    }

    @Override
    public Optional<Table> getTableById(long id) {
        return tableRepository.findById(id);
    }

    @Override
    public Table createTable(Table table) {
        return tableRepository.save(table);
    }

    @Override
    public void saveAllTable(List<Table> tableList) {
        tableList.forEach(table -> createTable(table));
    }

    @Override
    public void deleteTable(Table table) {
        tableRepository.delete(table);
    }


}



