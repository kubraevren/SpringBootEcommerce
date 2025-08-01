package com.springprojem.kubraevren.repository;

import org.springframework.stereotype.Repository;

import com.springprojem.kubraevren.model.urun;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface urunRepository extends JpaRepository <urun, Long>{
            List<urun> findByAktifMiTrue();

     
 }
