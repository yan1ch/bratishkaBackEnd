package com.example.bratishka.bratishkaBackEnd.controllers;

import com.example.bratishka.bratishkaBackEnd.models.Barber;
import com.example.bratishka.bratishkaBackEnd.models.Shop;
import com.example.bratishka.bratishkaBackEnd.repositories.BarberRepository;
import com.example.bratishka.bratishkaBackEnd.services.BarberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbers")
public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @PostMapping("/by-shop")
    public ResponseEntity<List<Barber>> getBarbersByShop(@RequestBody Shop shop) {
        List<Barber> barbers = barberService.getBarbersByShop(shop);
        return ResponseEntity.ok(barbers);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Barber addBarber(@RequestBody Barber barber) {
        return barberService.saveBarber(barber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarber(@PathVariable long id) {
        if (!barberService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        barberService.deleteBarberById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable long id, @RequestBody Barber barber) {
        barber.setId(id);
        return ResponseEntity.ok(barberService.saveBarber(barber));
    }
}