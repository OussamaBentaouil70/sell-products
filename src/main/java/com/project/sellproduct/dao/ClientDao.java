package com.project.sellproduct.dao;

import com.project.sellproduct.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
  Client  findByNom(String nom);
  int deleteByNom(String nom);

    Client  findByPrenom(String prenom);

    Client findByNomAndPrenom(String nom, String prenom);

}
