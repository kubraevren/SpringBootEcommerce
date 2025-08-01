package com.springprojem.kubraevren.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springprojem.kubraevren.model.admin;

@Repository
public interface adminRepository extends JpaRepository<admin,Long>{
    Optional<admin> findByAdAndSifre(String ad, String sifre);

}

