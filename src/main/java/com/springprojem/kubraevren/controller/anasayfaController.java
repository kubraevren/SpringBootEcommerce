package com.springprojem.kubraevren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springprojem.kubraevren.model.urun;
import com.springprojem.kubraevren.repository.urunRepository;
@Controller
public class anasayfaController {
    /***Ne yapar**: Site ana sayfası ve genel sayfalar

- Ana sayfa
- Hakkımızda
- İletişim */


 //http://localhost:8080/kayit

 @Autowired
    private urunRepository urunRepository;




    @GetMapping("/")
    public String anasayfa(Model model) {
       List<urun> urunler = urunRepository.findByAktifMiTrue();
        model.addAttribute("urunler", urunler);
        return "home"; // templates/home.html dosyasını render eder
    }

}
