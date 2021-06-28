package com.restaurant.reservationApp.Guest;

import java.util.List;

public interface GuestRepository {
    public List<Guest> getAllGuests();
    public Guest getGuestById(long id);
    public Guest createGuest(Guest guest);
}
