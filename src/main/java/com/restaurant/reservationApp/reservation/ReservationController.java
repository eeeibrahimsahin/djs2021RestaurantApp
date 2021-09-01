package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.auth.CustomUserDetails;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeService;
import com.restaurant.reservationApp.guest.Guest;
import com.restaurant.reservationApp.guest.GuestService;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    GuestService guestService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    TableService tableService;
    private Reservation reservation;
    private Reservation willUpdateReservation;


    @PostMapping("/createNewReservation")
    public void createNewReservation(@RequestBody Reservation reservation) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
        Optional<Table> table = tableService.getTableById(reservation.getTable().getId());
        Guest guest = guestService.createGuest(reservation.getGuest());

        reservation.setGuest(guest);
        reservation.setTable(table.get());
        reservation.setEmployee(userDetails.getUser());
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
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/reservation", produces = "application/json", consumes = "application/json")
    public void Reservation(@RequestBody Reservation reservation) {
        reservationService.deleteReservation(reservation);
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
    public ResponseEntity<Map<String, Long>> getAmountOfGuestSoFar() {
        return new ResponseEntity<>(reservationService.getAmountOfGuest(), HttpStatus.OK);
    }

}
