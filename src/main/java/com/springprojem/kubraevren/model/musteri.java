package com.springprojem.kubraevren.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;  


@Data
@Entity
public class musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String email;
    private String sifre;

    // Getter ve Setter'lar
}





