package com.springprojem.kubraevren.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class adminController {

    /***Ne yapar**: Ana yönetici sayfası

- Dashboard
- İstatistikler
- Ana sayfa
     * 
     * 
     */


    @GetMapping("/admin")
    public String adminAnasayfa() {
        return "admin/adminDashboard";  // templates/admin/adminAnasayfa.html dosyasını gösterir
    }
   
}
