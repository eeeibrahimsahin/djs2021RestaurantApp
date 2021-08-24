package com.restaurant.reservationApp.menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    Optional<Menu> getMenuById(long id);

    List<Menu> findAllMenu();

    Menu save(Menu menu);

    Menu updateMenu(Menu menu);

    void deleteMenu(long id);
}
