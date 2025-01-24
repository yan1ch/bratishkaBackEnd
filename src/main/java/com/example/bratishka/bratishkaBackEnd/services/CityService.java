package com.example.bratishka.bratishkaBackEnd.services;

import com.example.bratishka.bratishkaBackEnd.models.City;
import com.example.bratishka.bratishkaBackEnd.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public List<City> getAllCitiesSortedByName() {
        return cityRepository.findAllByOrderByCityNameAsc();
    }

    public void deleteCityById(long id) {
        cityRepository.deleteById(id);
    }
}