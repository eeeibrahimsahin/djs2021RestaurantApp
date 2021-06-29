package com.restaurant.reservationApp.reservation;
import com.restaurant.reservationApp.Table.Table;
import com.restaurant.reservationApp.Table.TableRepository;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Reservation  deleteReservation (Reservation  reservation) {
        return reservationRepository.deleteReservation (reservation);
    }
}
