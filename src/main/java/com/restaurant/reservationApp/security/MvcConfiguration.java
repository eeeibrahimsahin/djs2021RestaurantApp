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
        registry.addViewController("/guest").setViewName("guest");
        registry.addViewController("/employees").setViewName("employees");
        registry.addViewController("/create_employee").setViewName("create_employee");
        registry.addViewController("/update_employee").setViewName("update_employee");
    }
}
