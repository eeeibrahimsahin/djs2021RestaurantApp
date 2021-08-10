package com.restaurant.reservationApp.reservation;
import com.restaurant.reservationApp.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    ReservationRepository reservationRepository;

    public ReservationServiceImpl() {
    }

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservation() {

        return reservationRepository.getAllReservation();
    }

    @Override
    public Reservation getReservationById(long id) {
        return reservationRepository.getReservationById(id);
    }

    @Override
    public Reservation  createReservation (Reservation reservation ) {
        return reservationRepository.createReservation (reservation);
    }

    @Override
    public void deleteReservation(long id) {
        reservationRepository.deleteReservation(id);
    }

    @Override
    public List<Table> getAvailableTables(String dateAndTime) {
        return reservationRepository.getAvailableTables(dateAndTime);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.updateReservation(reservation);
    }
}
