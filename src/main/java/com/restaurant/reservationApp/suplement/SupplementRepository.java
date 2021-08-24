package com.restaurant.reservationApp.suplement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends CrudRepository<Supplement,Long> {
}
