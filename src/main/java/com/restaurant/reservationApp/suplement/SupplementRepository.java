package com.restaurant.reservationApp.suplement;

import java.util.List;

public interface SupplementRepository {
    List<Supplement> getAllSupplements();

    Supplement getSupplementById(long id);
}
