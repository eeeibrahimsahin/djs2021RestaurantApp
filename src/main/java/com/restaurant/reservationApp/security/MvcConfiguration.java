package com.restaurant.reservationApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/reservations").setViewName("reservations");
        registry.addViewController("/create_reservation").setViewName("create_reservation");
        registry.addViewController("/orders").setViewName("orders");
        registry.addViewController("/order_create").setViewName("order_create");
        registry.addViewController("/guests").setViewName("guests");
        registry.addViewController("/create_guest").setViewName("create_guest");
        registry.addViewController("/update_guest").setViewName("update_guest");
        registry.addViewController("/employees").setViewName("employees");
        registry.addViewController("/create_employee").setViewName("create_employee");
        registry.addViewController("/update_employee").setViewName("update_employee");
        registry.addViewController("/tables").setViewName("tables");
        registry.addViewController("/create_table").setViewName("create_table");
        registry.addViewController("/foods").setViewName("foods");
        registry.addViewController("/add_stock").setViewName("add_stock");
    }
}
