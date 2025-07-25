package com.springprojem.kubraevren.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springprojem.kubraevren.model.musteri;
import com.springprojem.kubraevren.repository.musteriRepository;

@Service
public class musteriService {

    @Autowired
    private musteriRepository musteriRepository;

    public musteri kaydet(musteri musteri) {
        return musteriRepository.save(musteri);
    }

    
    public Optional<musteri> girisYap(String ad, String sifre) {
        Optional<musteri> musteri = musteriRepository.findByAdAndSifre(ad, sifre);
        return musteri;
    }
    
    
}
