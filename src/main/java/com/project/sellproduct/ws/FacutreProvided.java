package com.project.sellproduct.ws;

import com.project.sellproduct.bean.Facture;
import com.project.sellproduct.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sell-products/facutre")
public class FacutreProvided {
    @GetMapping("/reference/{reference}")
    public Facture findByReference(@PathVariable String reference) {
        return factureService.findByReference(reference);
    }

    @GetMapping("/client/nom/{nom}")
    public List<Facture> findByClientNom(@PathVariable String nom) {
        return factureService.findByClientNom(nom);
    }

    @DeleteMapping("/client/nom/{nom}")
    public int deleteByClientNom(@PathVariable String nom) {
        return factureService.deleteByClientNom(nom);
    }

    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Facture facture) {
        return factureService.save(facture);
    }


    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        factureService.deleteById(id);
    }

    @Autowired
    private FactureService factureService;
}
