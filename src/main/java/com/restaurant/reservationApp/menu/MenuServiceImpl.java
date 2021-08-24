package com.restaurant.reservationApp.menu;

import com.restaurant.reservationApp.db.SequenceGeneratorService;
import com.restaurant.reservationApp.exception.NotFoundException;
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
        Optional<Menu> menuOptional = menuRepository.findById(menu.getId());
        if(menuOptional.isEmpty()) throw new NotFoundException();
        menuOptional.get().setName(menu.getName());
        menuOptional.get().setPrice(menu.getPrice());
        menuOptional.get().setDescription(menu.getDescription());
        menuOptional.get().setType(menu.getType());
        menuRepository.save(menuOptional.get());
        return menuOptional.get();
    }

    @Override
    public void deleteMenu(long id) {
        menuRepository.deleteById(id);
    }
}
