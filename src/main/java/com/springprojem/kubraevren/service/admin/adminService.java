package com.springprojem.kubraevren.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springprojem.kubraevren.model.admin;
import com.springprojem.kubraevren.repository.adminRepository;
@Service
public class adminService {
    
    @Autowired
    private adminRepository adminRepository;

    public admin kaydet(admin admin) {
        return adminRepository.save(admin);
    }

    
    public Optional<admin> girisYap(String ad, String sifre) {
        Optional<admin> admin = adminRepository.findByAdAndSifre(ad, sifre);
        return admin;
    }
    
}
