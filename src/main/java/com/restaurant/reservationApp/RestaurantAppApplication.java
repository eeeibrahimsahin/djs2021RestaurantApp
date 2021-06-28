package com.restaurant.reservationApp;

import com.restaurant.reservationApp.Payment.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class RestaurantAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantAppApplication.class, args);
	}


}
