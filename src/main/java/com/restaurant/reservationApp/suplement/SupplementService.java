package com.restaurant.reservationApp.suplement;

import java.util.List;
import java.util.Optional;

public interface SupplementService {
    static Supplement getSupplementByName(String name) {
        return null;
    }

    List getAllSupplements();

    Supplement createSupplement(Supplement supplement);

    Optional<Supplement> getSupplementById(long id);

    List getSupplementsLessThan(long amount);

}
