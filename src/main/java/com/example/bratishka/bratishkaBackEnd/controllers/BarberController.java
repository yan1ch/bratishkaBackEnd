package com.example.bratishka.bratishkaBackEnd.controllers;

import com.example.bratishka.bratishkaBackEnd.models.Barber;
import com.example.bratishka.bratishkaBackEnd.services.BarberService;
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

    @GetMapping("/shops/links")
    public ResponseEntity<List<String>> getAllShopLinks() {
        return ResponseEntity.ok(barberService.getAllShopLinks());
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
