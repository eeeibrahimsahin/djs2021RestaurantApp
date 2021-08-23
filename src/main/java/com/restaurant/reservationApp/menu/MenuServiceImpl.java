package com.restaurant.reservationApp.menu;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    SequenceGeneratorService sequenceGenerator;

    @Override
    public Optional<Menu> getMenuById(long id) {
        return menuRepository.findById(id);
    }

    @Override
    public List<Menu> findAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Menu save(Menu menu) {
        menu.setId(sequenceGenerator.generateSequence(Menu.SEQUENCE_NAME));
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Menu menu) {
        menuRepository.delete(menu);
    }
}
