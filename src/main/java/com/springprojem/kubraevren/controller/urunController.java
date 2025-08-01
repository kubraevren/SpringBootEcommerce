package com.springprojem.kubraevren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Spring'in Model interface'i
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springprojem.kubraevren.model.urun;
import com.springprojem.kubraevren.repository.urunRepository;

@Controller
public class urunController {

    @Autowired
    private urunRepository urunRepository;

    @GetMapping("/urunDetay/{id}")
    public String urunDetay(@PathVariable Long id, Model model) {
        urun urun = urunRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
        model.addAttribute("urun", urun);
        return "urunDetay"; 
    }
}

 /*
     * **Ne yapar**: Müşterilerin ürün görme işleri

- Ürün listesi (müşteri görünümü)
- Ürün detayı
- Ürün arama
     */