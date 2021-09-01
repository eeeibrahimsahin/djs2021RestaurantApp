package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.table.Table;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> getAllReservation();

    Optional<Reservation> getReservationById(long id);

    Reservation createReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);

    List<Table> getAvailableTables(String dateAndTime);

    Map<String, Long> getAmountOfGuest();


}
