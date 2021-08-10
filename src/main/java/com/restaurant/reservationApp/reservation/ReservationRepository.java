package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.table.Table;

import java.util.List;

public interface ReservationRepository {
    public List<Reservation> getAllReservation();
    public Reservation getReservationById(long id);
    public Reservation createReservation(Reservation reservation);
    public void deleteReservation(long id);

    List<Table> getAvailableTables(String dateAndTime);

    public Reservation updateReservation(Reservation reservation);
}
