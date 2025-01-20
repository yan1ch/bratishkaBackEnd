package com.example.bratishka.bratishkaBackEnd.controllers;

import com.example.bratishka.bratishkaBackEnd.models.Ad;
import com.example.bratishka.bratishkaBackEnd.services.AdService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping("/getAllAds")
    public ResponseEntity<List<Ad>> getAllAds() {
        List<Ad> ads = adService.getAllAdsSortedByNumber();
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ad> addAd(@Valid @RequestBody Ad ad, BindingResult bindingResult) {
        System.out.println(ad.getLink());

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ad createdAd = adService.addAd(ad);
        return new ResponseEntity<>(createdAd, HttpStatus.CREATED);
    }

    @PostMapping("/swapLeft")
    public ResponseEntity<Ad> swapLeft(@Valid @RequestBody Ad ad, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ad = adService.swapLeft(ad);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @PostMapping("/swapRight")
    public ResponseEntity<Ad> swapRight(@Valid @RequestBody Ad ad, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ad = adService.swapRight(ad);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adService.deleteAdById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
