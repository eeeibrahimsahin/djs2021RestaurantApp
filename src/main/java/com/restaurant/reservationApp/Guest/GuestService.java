package com.restaurant.reservationApp.Guest;

import java.util.List;

public interface GuestService {
    public List<Guest> getAllGuests();
    public Guest getGuestById(long id);
    public Guest createGuest(Guest guest);
}
