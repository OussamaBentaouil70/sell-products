package com.project.sellproduct.ws;

import com.project.sellproduct.bean.Produit;
import com.project.sellproduct.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sell-products/produit")
public class ProduitProvided {

    @GetMapping("/reference/{reference}")
    public Produit findByReference(@PathVariable String reference) {
        return produitService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return produitService.deleteByReference(reference);
    }
@GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }



    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        produitService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public Optional<Produit> findById(@PathVariable Long id) {
        return produitService.findById(id);
    }

    @GetMapping("/facture/reference/{reference}")
    public List<Produit> findByFactureReference(String reference) {
        return produitService.findByFactureReference(reference);
    }

    @Autowired
    private ProduitService produitService;
}
