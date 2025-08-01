package com.springprojem.kubraevren.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springprojem.kubraevren.model.musteri;
import com.springprojem.kubraevren.service.musteriService;

@Controller
public class girisCikisController {
    /***Ne yapar**: Giriş/çıkış işlemleri

- Giriş yap
- Kayıt ol
- Çıkış yap */

 @Autowired
 private musteriService musteriService;


 @GetMapping("/giris") 
     public String giris() {
     return "girisYap"; 
      }

       
    @GetMapping("/kayit") 
    public String kayit() {
    return "kayitOl"; 
     }


      @PostMapping("/musterigiris")
    @ResponseBody 
    public ResponseEntity<?> musterigiris(@RequestBody Map<String, String> giris) {
        String ad = giris.get("ad"); 
        String sifre = giris.get("sifre");

        Optional<musteri> musteri = musteriService.girisYap(ad, sifre);
        if (musteri.isPresent()) {
            return ResponseEntity.ok(musteri.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Hatalı giriş");
    }


   

     
    @PostMapping("/musterikayit")
    public ResponseEntity<musteri> musterikayit(@RequestBody musteri musteri) {
        musteri kaydedilen = musteriService.kaydet(musteri);
        return ResponseEntity.ok(kaydedilen);
    }

}
