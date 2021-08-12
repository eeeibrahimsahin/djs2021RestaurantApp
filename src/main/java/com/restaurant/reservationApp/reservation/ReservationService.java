package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.table.Table;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ReservationService {
    public List<Reservation> getAllReservation();

    public Optional<Reservation> getReservationById(long id);

    public Reservation createReservation(Reservation reservation);

    public void deleteReservation(Reservation reservation);

    List<Table> getAvailableTables(String dateAndTime);


    Map<String, Long> getAmountOfGuest();
}
