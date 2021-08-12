package com.restaurant.reservationApp.guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    public List<Guest> getAllGuests();
    public Optional<Guest> getGuestById(long id);
    public Guest createGuest(Guest guest);
    public void deleteGuest(long id);
    public Guest updateGuest(Guest guest);
}
