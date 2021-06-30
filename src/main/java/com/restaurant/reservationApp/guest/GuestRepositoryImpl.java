package com.restaurant.reservationApp.guest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class GuestRepositoryImpl implements GuestRepository {
    List<Guest> list = Arrays.asList(
            new Guest(1, "Mila", "Bom", 061234567, 234),
            new Guest(2, "Alex", "De Souza", 061234567, 345),
            new Guest(3, "Yolant", "Verbulen", 061234567, 456),
            new Guest(4, "Johan", "Cruyff", 061234567, 567),
            new Guest(5, "Pogba", "Henry", 061234567, 678),
            new Guest(6, "Sedat", "Peker", 061234567, 789)
    );

    public GuestRepositoryImpl() {
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
        guest.setId(list.size() + 1);
        list.add(guest);
        return guest;
    }
}
