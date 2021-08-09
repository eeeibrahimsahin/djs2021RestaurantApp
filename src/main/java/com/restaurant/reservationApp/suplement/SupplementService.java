package com.restaurant.reservationApp.suplement;

import java.util.List;

public interface SupplementService {
    static Supplement getSupplementByName(String name) {
        return null;
    }

    List<Supplement> getAllSupplements();

    public Supplement getSupplementById(long id);
}
