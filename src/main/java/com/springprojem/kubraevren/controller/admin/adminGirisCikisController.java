package com.springprojem.kubraevren.controller.admin;

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

import com.springprojem.kubraevren.model.admin;
import com.springprojem.kubraevren.service.admin.adminService;
@Controller
public class adminGirisCikisController {
     @Autowired
 private adminService adminService;

    @GetMapping("/adminkayit") 
    public String adminkayit() {
    return "admin/adminkayit"; 
     }

     @GetMapping("/admingiris") 
     public String admingiris() {
     return "admin/admingiris"; 
      }



    @PostMapping("/kayit")
    public ResponseEntity<admin> kayit(@RequestBody admin admin) {
        admin kaydedilen = adminService.kaydet(admin);
        return ResponseEntity.ok(kaydedilen);
    }

    @PostMapping("/giris")
    @ResponseBody 
    public ResponseEntity<?> giris(@RequestBody Map<String, String> giris) {
        String ad = giris.get("ad"); 
        String sifre = giris.get("sifre");

        Optional<admin> admin = adminService.girisYap(ad, sifre);
        if (admin.isPresent()) {
            return ResponseEntity.ok(admin.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Hatalı giriş");
    }
}
