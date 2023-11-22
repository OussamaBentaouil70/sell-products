package com.project.sellproduct.service;

import com.project.sellproduct.bean.Client;
import com.project.sellproduct.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private FactureService factureService;
    public Client findByNom(String nom) {
        return clientDao.findByNom(nom);
    }

    @Transactional
    public int deleteByNom(String nom) {
      int resultFacutre = factureService.deleteByClientNom(nom);
        int resultClient =  clientDao.deleteByNom(nom);
        return  resultClient+ resultFacutre;
    }


    public Client findByPrenom(String prenom) {
        return clientDao.findByPrenom(prenom);
    }

    public Client findByNomAndPrenom(String nom, String prenom) {
        return clientDao.findByNomAndPrenom(nom, prenom);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public int save(Client client) {
        if (findById(client.getId()).isPresent()) {
            return -1;
        } else {

            clientDao.save(client);

        }
        return 1;
    }

    public Optional<Client> findById(Long id) {
        return clientDao.findById(id);
    }


    @Autowired
    private ClientDao clientDao;
}
