package com.restaurant.reservationApp.suplement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SupplementRepository extends CrudRepository<Supplement,Long> {
//    List<Supplement> getAllSupplements();
//
//    Supplement getSupplementById(long id);
}
