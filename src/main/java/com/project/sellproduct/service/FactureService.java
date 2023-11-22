package com.project.sellproduct.service;

import com.project.sellproduct.bean.Client;
import com.project.sellproduct.bean.Facture;
import com.project.sellproduct.dao.FactureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FactureService {
    public Facture findByReference(String reference) {
        return factureDao.findByReference(reference);
    }

    public List<Facture> findByClientNom(String nom) {
        return factureDao.findByClientNom(nom);
    }

    @Transactional
    public int deleteByClientNom(String nom) {
        return factureDao.deleteByClientNom(nom);
    }

    public List<Facture> findAll() {
        return factureDao.findAll();
    }

    public int save(Facture facture) {
        if (findByReference(facture.getReference())!= null){
            return -1;
        }
Client client = clientService.findByNom(facture.getClient().getNom());
        facture.setClient(client);
        if (client== null){
            return -2;
        } else {
            factureDao.save(facture);
            return 1;
        }
    }

    @Transactional
    public void deleteById(Long id) {
        factureDao.deleteById(id);
    }
    @Autowired
    private ClientService clientService;
@Autowired
    private FactureDao factureDao;
}
