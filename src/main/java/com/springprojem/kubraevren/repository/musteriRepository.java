package com.springprojem.kubraevren.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springprojem.kubraevren.model.musteri;
@Repository
public interface musteriRepository extends JpaRepository<musteri, Long> {


    Optional<musteri> findByAdAndSifre(String ad, String sifre);
}




