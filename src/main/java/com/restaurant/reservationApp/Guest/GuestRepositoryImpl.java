package com.restaurant.reservationApp.Guest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GuestRepositoryImpl implements GuestRepository{
    List<Guest> list = new ArrayList<>();

    public GuestRepositoryImpl() {
        Guest guest = new Guest();
        guest.setId(1);
        guest.setFirstName("Saif");
        list.add(guest);
    }
        @Override
        public List<Guest> getAllGuests() {
            return list;
        }
        @Override
        public Guest getGuestById(long id) {
            Optional<Guest> guest1 = list.stream().filter(guest -> guest.getId() == id).findFirst();
            return guest1.get();
        }

    @Override
    public Guest createGuest(Guest guest) {
        guest.setId(list.size()+1);
        list.add(guest);
        return guest;
    }
}
