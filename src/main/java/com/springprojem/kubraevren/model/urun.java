
package com.springprojem.kubraevren.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urunId;
    
    private String urunAdi;
    private String kategori;
    private double fiyat;
    private int stokAdedi;
    private String aciklama;
    private boolean indirimliMi;    
    private double indirimOrani;      
    private boolean aktifMi;         
    private String resimUrl;
    private double puan;              
    
    private int yorumSayisi = 0;            
    
    private String depoAdi = "Ana Depo"; 


    private LocalDate eklenmeTarihi;
    
    @PrePersist
    public void setEklenmeTarihi() {
        this.eklenmeTarihi = LocalDate.now();
    }
}