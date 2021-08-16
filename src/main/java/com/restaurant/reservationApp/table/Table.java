package com.restaurant.reservationApp.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "tables")
public class Table {
    @Transient
    public static final String SEQUENCE_NAME = "tables_sequence";
    @Id
    private long id;
    private int numberOfChairs;
    private int floor;
}
