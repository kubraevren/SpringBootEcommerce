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



   /*  public Optional<musteri> girisYap(String email, String sifre) {
        // Test verisi (veritabanı bağlanmadan)
        if (email.equals("test@mail.com") && sifre.equals("1234")) {
            musteri testMusteri = new musteri();
            testMusteri.setEmail(email);
            testMusteri.setSifre(sifre);
            return Optional.of(testMusteri);
        }
        return Optional.empty();
    }*/

    

    
     public Optional<musteri> girisYap(String email, String sifre) {
        Optional<musteri> musteri = musteriRepository.findByEmail(email);
        if (musteri.isPresent() && musteri.get().getSifre().equals(sifre)) {
            return musteri;
        }
        return Optional.empty();
    }
}
