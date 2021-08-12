package com.restaurant.reservationApp.guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GuestRepository extends CrudRepository<Guest,Long> {
    /*public List<Guest> getAllGuests();
    public Guest getGuestById(long id);
    public Guest createGuest(Guest guest);
    void deleteGuest(long id);
    Guest updateGuest(Guest guest);*/
}
