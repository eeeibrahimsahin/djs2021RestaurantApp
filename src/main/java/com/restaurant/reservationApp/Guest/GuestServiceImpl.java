package com.restaurant.reservationApp.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService{
    GuestRepository guestRepository;
    public GuestServiceImpl(){

    }
    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> getAllGuests() {

        return guestRepository.getAllGuests();
    }

    @Override
    public Guest getGuestById(long id) {

        return guestRepository.getGuestById(id);
    }

    @Override
    public Guest createGuest(Guest guest) {

        return guestRepository.createGuest(guest);
    }

}
