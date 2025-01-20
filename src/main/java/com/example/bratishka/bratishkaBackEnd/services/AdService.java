package com.example.bratishka.bratishkaBackEnd.services;

import com.example.bratishka.bratishkaBackEnd.models.Ad;
import com.example.bratishka.bratishkaBackEnd.repositories.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {

    private final AdRepository adRepository;

    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<Ad> getAllAdsSortedByNumber() {
        return adRepository.findAllByOrderByNumberAsc();
    }

    public Ad addAd(Ad ad) {
        return adRepository.save(ad);
    }

    public void deleteAdById(Long id) {
        adRepository.deleteById(id);
    }

    public Ad swapLeft(Ad ad) {
        Ad adLeft = adRepository.findClosestLessThan(ad.getNumber());
        if (adLeft != null) {
            int temp = ad.getNumber();
            ad.setNumber(adLeft.getNumber());
            adLeft.setNumber(temp);

            adRepository.save(adLeft);
            adRepository.save(ad);
        }
        return ad;
    }

    public Ad swapRight(Ad ad) {
        Ad adRight = adRepository.findClosestGreaterThan(ad.getNumber());
        if (adRight != null) {
            int temp = ad.getNumber();
            ad.setNumber(adRight.getNumber());
            adRight.setNumber(temp);

            adRepository.save(adRight);
            adRepository.save(ad);
        }
        return ad;
    }
}
