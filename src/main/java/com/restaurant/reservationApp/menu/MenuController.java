package com.restaurant.reservationApp.menu;

import com.restaurant.reservationApp.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable long id) {
        Optional<Menu> menuOptional = menuService.getMenuById(id);
        if (menuOptional.isEmpty())
            throw new NotFoundException();
        return new ResponseEntity<>(menuOptional.get(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenu() {
        return new ResponseEntity<>(menuService.findAllMenu(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.save(menu), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.updateMenu(menu), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteMenu(@RequestBody Menu menu) {
        menuService.deleteMenu(menu);
    }
}
