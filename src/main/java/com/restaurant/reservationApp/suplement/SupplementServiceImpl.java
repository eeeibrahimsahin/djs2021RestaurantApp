package com.restaurant.reservationApp.suplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplementServiceImpl implements SupplementService {
    @Autowired
    private SupplementRepository supplementRepository;

    @Override
    public List<Supplement> getAllSupplements() {
        return supplementRepository.getAllSupplements();
    }

    @Override
    public Supplement getSupplementById(long id) {
        return supplementRepository.getSupplementById(id);
    }


}
