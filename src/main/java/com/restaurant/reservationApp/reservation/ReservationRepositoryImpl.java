package com.restaurant.reservationApp.reservation;
import com.restaurant.reservationApp.Table.Table;
import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.order.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ReservationRepositoryImpl implements ReservationRepository{
    private List<Reservation> reservationList = new ArrayList<>();

    public ReservationRepositoryImpl() {
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setBookingDate(new Date(System.currentTimeMillis()));
        reservation.setReservationDate();//buna ne yapmaliyim?
        reservationList.add(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationList;
    }

    @Override
    public Reservation getReservationById(long id) {
        Reservation reservation= reservationList.stream().filter(reservation1  -> reservation1.getId()==id).findFirst().get();
        return reservation;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        reservation.setId(reservationList.size() + 1);
        reservationList.add(reservation);
        return reservation;
    }

    @Override
    public Reservation deleteReservation(Reservation reservation) {
        reservation.setId(reservationList.size()-1);
        return reservation;
    }

}
