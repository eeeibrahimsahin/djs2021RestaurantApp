package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.table.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
//    public List<Reservation> getAllReservation();
//    public Reservation getReservationById(long id);
//    public Reservation createReservation(Reservation reservation);
//    public Reservation deleteReservation(Reservation reservation);
//
//    List<Table> getAvailableTables(String dateAndTime);
}
