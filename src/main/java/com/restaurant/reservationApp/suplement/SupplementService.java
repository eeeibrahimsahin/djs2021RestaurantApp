package com.restaurant.reservationApp.suplement;

import java.util.List;
import java.util.Optional;

public interface SupplementService {
    static Supplement getSupplementByName(String name) {
        return null;
    }

    List<Supplement> getAllSupplements();

    public Optional<Supplement> getSupplementById(long id);

    List getSupplementsLessThan(long amount);
}
