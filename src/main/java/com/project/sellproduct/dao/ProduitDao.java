package com.project.sellproduct.dao;

import com.project.sellproduct.bean.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {
    Produit findByReference(String reference);

    List<Produit> findByFactureReference(String reference);
    int deleteByReference(String reference);

}
