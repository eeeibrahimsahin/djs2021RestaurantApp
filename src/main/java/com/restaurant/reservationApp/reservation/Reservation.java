package com.restaurant.reservationApp.reservation;

import com.restaurant.reservationApp.guest.Guest;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.employee.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {
    private long id;
    private Employee employee;
    private Table table;
    private Guest guest;
    private Date bookingDate;
    private LocalDateTime reservationDate;

    public Reservation() {
    }

    public Reservation(long id, Employee employee, Table table, Guest guest, Date bookingDate, LocalDateTime reservationDate) {
        this.id = id;
        this.employee = employee;
        this.table = table;
        this.guest = guest;
        this.bookingDate = bookingDate;
        this.reservationDate = reservationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate() {
        this.reservationDate = reservationDate;
    }
}
