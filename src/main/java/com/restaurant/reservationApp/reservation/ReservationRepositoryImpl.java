package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeRepositoryImpl;
import com.restaurant.reservationApp.guest.Guest;
import com.restaurant.reservationApp.guest.GuestRepositoryImpl;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableRepositoryImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class ReservationRepositoryImpl implements ReservationRepository {
    private List<Reservation> reservationList = new ArrayList<>(Arrays.asList(
            new Reservation(1, new EmployeeRepositoryImpl().getEmployeeById(1), new TableRepositoryImpl().getTableById(1),
                    new GuestRepositoryImpl().getGuestById(1), new Date(System.currentTimeMillis()), LocalDateTime.of(2021, 07, 13, 12, 00)),
            new Reservation(2, new EmployeeRepositoryImpl().getEmployeeById(2), new TableRepositoryImpl().getTableById(2),
                    new GuestRepositoryImpl().getGuestById(2), new Date(System.currentTimeMillis()), LocalDateTime.of(2021, 07, 13, 13, 00)),
            new Reservation(3, new EmployeeRepositoryImpl().getEmployeeById(3), new TableRepositoryImpl().getTableById(3),
                    new GuestRepositoryImpl().getGuestById(3), new Date(System.currentTimeMillis()), LocalDateTime.of(2021, 07, 15, 14, 00)),
            new Reservation(4, new EmployeeRepositoryImpl().getEmployeeById(4), new TableRepositoryImpl().getTableById(4),
                    new GuestRepositoryImpl().getGuestById(4), new Date(System.currentTimeMillis()), LocalDateTime.of(2021, 07, 16, 15, 00)),
            new Reservation(5, new EmployeeRepositoryImpl().getEmployeeById(5), new TableRepositoryImpl().getTableById(5),
                    new GuestRepositoryImpl().getGuestById(5), new Date(System.currentTimeMillis()), LocalDateTime.of(2021, 07, 17, 16, 00)),
            new Reservation(6, new EmployeeRepositoryImpl().getEmployeeById(6), new TableRepositoryImpl().getTableById(6),
                    new GuestRepositoryImpl().getGuestById(6), new Date(System.currentTimeMillis()), LocalDateTime.of(2021, 07, 18, 17, 00))

    ));

    public ReservationRepositoryImpl() {

    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationList;
    }

    @Override
    public Reservation getReservationById(long id) {
        Reservation reservation = reservationList.stream().filter(reservation1 -> reservation1.getId() == id).findFirst().get();
        return reservation;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        reservation.setId(reservationList.size() + 1);
        reservationList.add(reservation);
        return reservation;
    }

    @Override
    public void deleteReservation(long id) {
        for(Reservation reservation:reservationList){
            if (reservation.getId()==id){
                reservationList.remove(reservation);
                break;
            }

        }
    }

//    @Override
//    public Reservation deleteReservation(Reservation reservation) {
//        reservation.setId(reservationList.size() - 1);
//        return reservation;
//    }
    //public Reservation deleteReservation(Reservation reservation) {
    //1---for(Reservation reservation:list){
    //            if (reservation.getId()==id){
    //                list.remove(reservation);
    //                break;}
//2--- reservation = reservationList.stream().filter(reservation1 -> reservation1.getId() == id).findFirst().get();
    //list.remove(reservation);

    @Override
    public List<Table> getAvailableTables(String dateAndTime) {
        List<Table> availableTableList = new ArrayList<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime);
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationDate().isBefore(dateTime) || reservation.getReservationDate().isAfter(dateTime)) {
                availableTableList.add(reservation.getTable());
            }
        }
        return availableTableList;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        final Optional<Reservation> willUpdateReservation = reservationList.stream().filter(reservation1 -> reservation1.getId() == reservation.getId()).findFirst();
        if (willUpdateReservation.isPresent()){
            willUpdateReservation.get().setGuest(reservation.getGuest());
            willUpdateReservation.get().setTable(reservation.getTable());
//            willUpdateReservation.get().setReservationDate(reservation.getReservationDate());
            return willUpdateReservation.get();
        }
        return null;
    }

}
