package com.restaurant.reservationApp.guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    List<Guest> getAllGuests();

    Optional<Guest> getGuestById(long id);

    Guest createGuest(Guest guest);

    void deleteGuest(long id);

    void saveAllGuest(List<Guest> guestList);

    Guest updateGuest(Guest guest);
}
