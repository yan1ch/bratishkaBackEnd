package com.example.bratishka.bratishkaBackEnd.controllers;

import com.example.bratishka.bratishkaBackEnd.models.Ad;
import com.example.bratishka.bratishkaBackEnd.services.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdController {

    private final AdService adService;

    @GetMapping
    public ResponseEntity<List<Ad>> getAllAds() {
        List<Ad> ads = adService.getAllAdsSortedByNumber();
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ad> addAd(@RequestBody Ad ad) {
        Ad createdAd = adService.addAd(ad);
        return new ResponseEntity<>(createdAd, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adService.deleteAdById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
