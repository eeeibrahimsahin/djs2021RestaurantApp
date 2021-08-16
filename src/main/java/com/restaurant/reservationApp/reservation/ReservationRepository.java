package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.table.Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation,Long> {
}
