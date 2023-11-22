package com.project.sellproduct.service;

import com.project.sellproduct.bean.Produit;
import com.project.sellproduct.dao.ProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    public Produit findByReference(String reference) {
        return produitDao.findByReference(reference);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return produitDao.deleteByReference(reference);
    }

    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    public int save(Produit produit) {
        if (findByReference(produit.getReference()) != null) {
            return -1;
        } else {
            produitDao.save(produit);
        }
        return 1;
    }

    public Optional<Produit> findById(Long id) {
        return produitDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        produitDao.deleteById(id);
    }

    public List<Produit> findByFactureReference(String reference) {
        return produitDao.findByFactureReference(reference);
    }

    @Autowired
    private ProduitDao produitDao;
}
