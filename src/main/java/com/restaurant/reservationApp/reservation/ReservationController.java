package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeRepositoryImpl;
import com.restaurant.reservationApp.guest.Guest;
import com.restaurant.reservationApp.guest.GuestRepositoryImpl;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReservationController {
    private ReservationService reservationService;
    private Reservation willUpdateReservation;

    public ReservationController() {
    }

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/createNewReservation")
    public void createNewReservation(@RequestBody Reservation reservation) {
        System.out.println(reservation.toString());
        Employee employee = new EmployeeRepositoryImpl().getEmployeeById(1);
        Table table = new TableRepositoryImpl().getTableById(reservation.getTable().getId());
        Guest guest = new GuestRepositoryImpl().createGuest(reservation.getGuest());

        reservation.setGuest(guest);
        reservation.setTable(table);
        reservation.setEmployee(employee);
        reservation.setBookingDate(new Date(System.currentTimeMillis()));
        reservationService.createReservation(reservation);
    }

    @GetMapping("/allreservations")
    public ResponseEntity<List<Reservation>> getAllReservation() {

        List<Reservation> allReservation = reservationService.getAllReservation();
        return new ResponseEntity<>(allReservation, HttpStatus.OK);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable(name = "id", required = true) long id) {
        Reservation reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }


    @DeleteMapping("/reservation/{id}")
    public void deleteReservation(@PathVariable(name = "id") int id) {
        reservationService.deleteReservation(id);
    }

    @PutMapping(value = "/reservation")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        System.out.println(reservation.getReservationDate());
        Reservation reservation1 = reservationService.updateReservation(reservation);
        return new ResponseEntity<>(reservation1, HttpStatus.OK);
    }
    @PutMapping(value = "/willupdatereservation")
    public void setWillUpdateReservation(@RequestBody Reservation reservation) {
        willUpdateReservation =reservation;
    }
    @GetMapping("/reservation/update")
    public ResponseEntity<Reservation> getWillUpdateReservation() {
        return new ResponseEntity<>(willUpdateReservation, HttpStatus.OK);
    }


    @GetMapping("/getavailabletables/{dateAndTime}")
    public ResponseEntity<List<Table>> getAvailableTables(@PathVariable(name = "dateAndTime") String dateAndTime) {
        return new ResponseEntity<>(reservationService.getAvailableTables(dateAndTime), HttpStatus.OK);
    }

    @GetMapping("/amountofcustomer")
    public ResponseEntity<Map<String,Long>> getAmountOfGuestSoFar() {
        return new ResponseEntity<>(reservationService.getAmountOfGuest(), HttpStatus.OK);
    }

}
