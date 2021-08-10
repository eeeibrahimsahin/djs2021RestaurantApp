package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.table.Table;

import java.util.List;

public interface ReservationService {
    public List<Reservation> getAllReservation();
    public Reservation getReservationById(long id);
    public Reservation createReservation(Reservation reservation);
    void deleteReservation(long id);

    List<Table> getAvailableTables(String dateAndTime);

    Reservation updateReservation(Reservation reservation);
}
