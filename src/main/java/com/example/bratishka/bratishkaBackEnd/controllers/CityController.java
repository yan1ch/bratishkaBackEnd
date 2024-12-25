package com.example.bratishka.bratishkaBackEnd.controllers;

import com.example.bratishka.bratishkaBackEnd.models.City;
import com.example.bratishka.bratishkaBackEnd.services.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.saveCity(city));
    }

    @GetMapping("/getAllCities")
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCitiesSortedByName());
    }
}