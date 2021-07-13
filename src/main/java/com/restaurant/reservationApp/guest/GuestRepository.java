package com.restaurant.reservationApp.guest;

import java.util.List;

public interface GuestRepository {
    public List<Guest> getAllGuests();
    public Guest getGuestById(long id);
    public Guest createGuest(Guest guest);
    public Guest updateGuest(long id,String firstName, String lastName);
    void deleteGuest(long id);
}
