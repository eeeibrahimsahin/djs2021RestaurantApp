package com.restaurant.reservationApp.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    GuestRepository guestRepository;


    @Override
    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        Iterable<Guest> guestIterable = guestRepository.findAll();
        guestIterable.forEach(guests::add);
        return guests;
    }

    @Override
    public Optional<Guest> getGuestById(long id) {
        return guestRepository.findById(id);
    }

    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public void saveAllGuest(List<Guest> guestList) {
        guestList.forEach(guest -> createGuest(guest));
    }

    @Override
    public Guest updateGuest(Guest guest) {
        if (guestRepository.existsById(guest.getId())) {
            guestRepository.save(guest);
            return guest;
        }
        return null; //TODO: handle to return null issue.
    }

    @Override
    public void deleteGuest(long id) {
        guestRepository.deleteById(id);

    }


}
