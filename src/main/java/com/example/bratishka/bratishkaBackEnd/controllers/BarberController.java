package com.example.bratishka.bratishkaBackEnd.controllers;

import com.example.bratishka.bratishkaBackEnd.models.Barber;
import com.example.bratishka.bratishkaBackEnd.models.Shop;
import com.example.bratishka.bratishkaBackEnd.repositories.BarberRepository;
import com.example.bratishka.bratishkaBackEnd.services.BarberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbers")
public class BarberController {
    private final BarberService barberService;
    private final BarberRepository barberRepository;

    public BarberController(BarberService barberService, BarberRepository barberRepository) {
        this.barberService = barberService;
        this.barberRepository = barberRepository;
    }

    @PostMapping("/get")
    public ResponseEntity<List<Barber>> getBarbersByShop(@RequestBody Shop shop) {
        List<Barber> barbers = barberService.getBarbersByShop(shop);
        return ResponseEntity.ok(barbers);
    }


    @PostMapping("/add")
    public ResponseEntity<Barber> addBarber(@RequestBody Barber barber) {
        return ResponseEntity.ok(barberService.addBarber(barber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarber(@PathVariable long id) {
        barberService.deleteBarberById(id);
        return ResponseEntity.noContent().build();
    }
}
