package com.springprojem.kubraevren.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- EKLENDİ
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springprojem.kubraevren.model.urun;
import com.springprojem.kubraevren.repository.urunRepository;

@Controller
@RequestMapping("/admin/urun")
public class adminUrunController {

    @Autowired
    private urunRepository urunRepository;

    @GetMapping("/ekle")
    public String urunEkleFormu(Model model) {
        model.addAttribute("urun", new urun());
        return "admin/urunEkle";
    }


@PostMapping("/ekle")
public String urunKaydet(@ModelAttribute urun urun, Model model) {
    try {
        System.out.println("📦 Ürün verisi alındı: " + urun.getUrunAdi());
        
        // Varsayılan değerler - güvenlik için
        if (urun.getPuan() == 0) urun.setPuan(4.5);
        if (urun.getYorumSayisi() == 0) urun.setYorumSayisi(0);
        if (urun.getResimUrl() == null || urun.getResimUrl().trim().isEmpty()) {
            urun.setResimUrl("https://via.placeholder.com/200x200?text=Ürün+Resmi");
        }
        
        urunRepository.save(urun);
        System.out.println("✅ Ürün başarıyla kaydedildi: ID=" + urun.getUrunId());
        
        return "redirect:/";
        
    } catch (Exception e) {
        System.err.println("❌ Hata: " + e.getMessage());
        e.printStackTrace();
        model.addAttribute("error", "Kayıt hatası: " + e.getMessage());
        return "admin/urunEkle";
    }
}








/* 
 * **Ne yapar**: Ürünleri yönetir (sadece admin)

- Ürün ekle
- Ürün düzenle
- Ürün sil
- Ürün listesi (yönetici görünümü)
 * 
 * 
 */

 }