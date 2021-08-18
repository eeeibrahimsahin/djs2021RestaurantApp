package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.table.Table;

import java.util.List;
import java.util.Map;

public interface ReservationService {
    public List<Reservation> getAllReservation();
    public Reservation getReservationById(long id);
    public Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    public void deleteReservation(int id);

    List<Table> getAvailableTables(String dateAndTime);


    Map<String, Long> getAmountOfGuest();


}
