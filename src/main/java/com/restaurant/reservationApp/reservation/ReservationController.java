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

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReservationController {
    ReservationService reservationService;
    private Reservation reservation;
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


//    @PutMapping(value = "/reservation", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<Reservation> Reservation(@RequestParam(name = "reservation", required = false) String wish) {
//        if (wish == "create") {
//            Reservation reservation1 = reservationService.createReservation(reservation);
//            return new ResponseEntity<>(reservation1, HttpStatus.OK);
//        }
//        if (wish == "delete") {
//            Reservation reservation1 = reservationService.deleteReservation(id);
//            return new ResponseEntity<>(reservation1, HttpStatus.OK);
//        }
//        return null;
//    }
//    @PutMapping(value = "/reservation", produces = "application/json",consumes = "application/json")
//    public ResponseEntity<Reservation> Reservation(@RequestBody Reservation reservation){
//        Reservation reservation1 = reservationService.deleteReservation(reservation);
//        return new ResponseEntity<>(reservation1, HttpStatus.OK);
//    }


    @PutMapping(value = "/reservation")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
        Reservation reservation1  = reservationService.updateReservation(reservation);
        System.out.println("reservation1 = " + reservation1);
        return new ResponseEntity<>(reservation1, HttpStatus.OK);
    }


    @PutMapping(value = "/willupdatereservation")
    public void willUpdateReservation(@RequestBody Reservation reservation) {
        willUpdateReservation =reservation;
    }
    @GetMapping("/reservation/update")
    public ResponseEntity<Reservation> getWillUpdateReservation() {
        return new ResponseEntity<Reservation>(willUpdateReservation, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletereservation/{id}")
    public void deleteReservation(@PathVariable(name = "id") long id) {
        reservationService.deleteReservation(id);
    }


    @GetMapping("/getavailabletables/{dateAndTime}")
    public ResponseEntity<List<Table>> getAvailableTables(@PathVariable(name = "dateAndTime") String dateAndTime) {
        return new ResponseEntity<>(reservationService.getAvailableTables(dateAndTime), HttpStatus.OK);
    }

}
