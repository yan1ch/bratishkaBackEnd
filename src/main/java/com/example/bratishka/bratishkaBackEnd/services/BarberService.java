package com.example.bratishka.bratishkaBackEnd.services;

import com.example.bratishka.bratishkaBackEnd.models.Barber;
import com.example.bratishka.bratishkaBackEnd.models.Shop;
import com.example.bratishka.bratishkaBackEnd.repositories.BarberRepository;
import com.example.bratishka.bratishkaBackEnd.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {
    private final BarberRepository barberRepository;
    private final ShopRepository shopRepository;

    public BarberService(BarberRepository barberRepository, ShopRepository shopRepository) {
        this.barberRepository = barberRepository;
        this.shopRepository = shopRepository;
    }

    public Barber saveBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    public void deleteBarberById(long id) {
        barberRepository.deleteById(id);
    }

    public List<Barber> getBarbersByShopId(long shopId) {
        return barberRepository.findAllByShop(shopRepository.findById(shopId).get());
    }

    public boolean existsById(long id) {
        return barberRepository.existsById(id);
    }
}