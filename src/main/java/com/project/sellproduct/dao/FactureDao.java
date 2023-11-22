package com.project.sellproduct.dao;

import com.project.sellproduct.bean.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {
    Facture findByReference(String reference);
    List<Facture> findByClientNom(String nom);
    int deleteByClientNom(String nom);

}
