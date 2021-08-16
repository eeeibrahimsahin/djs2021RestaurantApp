package com.restaurant.reservationApp.suplement;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends MongoRepository<Supplement,Long> {
}
