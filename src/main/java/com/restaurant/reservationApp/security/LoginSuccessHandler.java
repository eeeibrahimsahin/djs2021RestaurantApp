package com.restaurant.reservationApp.security;

import com.restaurant.reservationApp.auth.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        System.out.println(authentication.getPrincipal());
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        List<String> roles = authorities.stream().map(auth -> auth.getAuthority()).collect(Collectors.toList());

        String redirectURL = request.getContextPath();
        if (roles.contains("ROLE_ADMIN")) {
            redirectURL += "/index";
        } else if (roles.contains("ROLE_RECEPTIONIST")) {
            redirectURL += "/reservations";
        } else if (roles.contains("ROLE_WAITER")) {
            redirectURL += "/order_create";
        } else if (roles.contains("ROLE_CASHIER")) {
            redirectURL += "/index";
        } else if (roles.contains("ROLE_CHEF")) {
            redirectURL += "/index";
        } else if (roles.contains("ROLE_KITCHEN")) {
            redirectURL += "/orders";
        }

        response.sendRedirect(redirectURL);
    }
}
