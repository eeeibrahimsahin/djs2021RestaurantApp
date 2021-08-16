package com.restaurant.reservationApp.guest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "guests")
public class Guest {
    @Transient
    public static final String SEQUENCE_NAME = "guests_sequence";
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private long roomNumber;
}
