package com.restaurant.reservationApp.food;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepository extends MongoRepository<Food, Long> {
}
