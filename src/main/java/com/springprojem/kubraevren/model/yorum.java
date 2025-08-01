package com.springprojem.kubraevren.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class yorum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kullaniciAdi;
    private String icerik;
    private double puan; // 1 ile 5 arası

    @ManyToOne
    @JoinColumn(name = "urun_id")
    private urun urun;
}
