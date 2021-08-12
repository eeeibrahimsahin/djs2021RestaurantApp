package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    TableRepository tableRepository;

    @Override
    public List<Reservation> getAllReservation() {
        List<Reservation> reservations = new ArrayList<>();
        Iterable<Reservation> reservationIterable = reservationRepository.findAll();
        reservationIterable.forEach(reservations::add);
        return reservations;
    }

    @Override
    public Optional<Reservation> getReservationById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Table> getAvailableTables(String dateAndTime) {
        return findAvailableTables(dateAndTime);
    }

    public List<Table> findAvailableTables(String dateAndTime) {
        List<Table> availableTableList = new ArrayList<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime);
        Iterable<Reservation> reservationList = reservationRepository.findAll();
        if (!reservationList.iterator().hasNext()) {

            Iterable<Table> tableIterable = tableRepository.findAll();
            tableIterable.forEach(availableTableList::add);
            return availableTableList;
        }
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationDate().isBefore(dateTime) || reservation.getReservationDate().isAfter(dateTime)) {
                availableTableList.add(reservation.getTable());
            }
        }
        return availableTableList;
    }


    @Override
    public Map<String, Long> getAmountOfGuest() {
        LocalDateTime now = LocalDateTime.now();
        long amountOfAllGuest = getAllReservation().stream().count();
        long amountOfGuestSoFar = getAllReservation().stream().filter(reservation -> now.isAfter(reservation.getReservationDate())).count();
        long amountOfGuestWhoVisitPlanned = getAllReservation().stream().filter(reservation -> reservation.getReservationDate().isAfter(now)).count();
        long amountOfGuestWhoVisitContinue = 2;

        Map<String, Long> amountOfGuestMap = new HashMap<>();
        amountOfGuestMap.put("amountOfGuestSoFar", amountOfGuestSoFar);
        amountOfGuestMap.put("amountOfGuestWhoVisitPlanned", amountOfGuestWhoVisitPlanned);
        amountOfGuestMap.put("amountOfGuestWhoVisitContinue", amountOfGuestWhoVisitContinue);
        return amountOfGuestMap;
    }
}
