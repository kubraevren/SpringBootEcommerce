package com.springprojem.kubraevren.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprojem.kubraevren.model.musteri;

@RestController
@RequestMapping("/musteri")
public class musteriController {
     @Autowired
    private musteriService musteriService;

    @PostMapping("/kayit")
    public ResponseEntity<musteri> kayit(@RequestBody musteri musteri) {
        musteri kaydedilen = musteriService.kaydet(musteri);
        return ResponseEntity.ok(kaydedilen);
    }

    @PostMapping("/giris")
    public ResponseEntity<?> giris(@RequestBody Map<String, String> giris) {
        String email = giris.get("email");
        String sifre = giris.get("sifre");

        Optional<musteri> musteri = musteriService.girisYap(email, sifre);
        if (musteri.isPresent()) {
            return ResponseEntity.ok(musteri.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Hatalı giriş");
    }
}

/*
 * Müşteri kayıt

Müşteri giriş

Ürünleri listele
 */