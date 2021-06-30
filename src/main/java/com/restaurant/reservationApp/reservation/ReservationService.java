package com.restaurant.reservationApp.reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> getAllReservation();
    public Reservation getReservationById(long id);
    public Reservation createReservation(Reservation reservation);
    public Reservation deleteReservation(Reservation reservation);
}