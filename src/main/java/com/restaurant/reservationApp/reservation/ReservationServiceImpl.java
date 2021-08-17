package com.restaurant.reservationApp.reservation;
import com.restaurant.reservationApp.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Reservation updateReservation(Reservation reservation) {

        return reservationRepository.updateReservation(reservation);
    }

    @Override
    public void deleteReservation (int id) {
        reservationRepository.deleteReservation (id);
    }

    @Override
    public List<Table> getAvailableTables(String dateAndTime) {
        return reservationRepository.getAvailableTables(dateAndTime);
    }
    @Override
    public Map<String, Long> getAmountOfGuest(){
        LocalDateTime now = LocalDateTime.now();
        long amountOfAllGuest = getAllReservation().stream().count();
        long amountOfGuestSoFar = getAllReservation().stream().filter(reservation ->now.isAfter(reservation.getReservationDate())).count();
        long amountOfGuestWhoVisitPlanned = getAllReservation().stream().filter(reservation ->reservation.getReservationDate().isAfter(now)).count();
        long amountOfGuestWhoVisitContinue = 2;

         Map<String,Long> amountOfGuestMap = new HashMap<>();
         amountOfGuestMap.put("amountOfGuestSoFar",amountOfGuestSoFar);
         amountOfGuestMap.put("amountOfGuestWhoVisitPlanned",amountOfGuestWhoVisitPlanned);
         amountOfGuestMap.put("amountOfGuestWhoVisitContinue",amountOfGuestWhoVisitContinue);
         return amountOfGuestMap;
    }
}
