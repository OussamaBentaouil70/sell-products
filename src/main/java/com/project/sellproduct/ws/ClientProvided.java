package com.project.sellproduct.ws;

import com.project.sellproduct.bean.Client;
import com.project.sellproduct.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sell-products/client")
public class ClientProvided {
    @GetMapping("/nom/{nom}")
    public Client findByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable String nom) {
        return clientService.deleteByNom(nom);
    }


    @GetMapping("/prenom/{prenom}")
    public Client findByPrenom(@PathVariable String prenom) {
        return clientService.findByPrenom(prenom);
    }

    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public Client findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return clientService.findByNomAndPrenom(nom, prenom);
    }

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }



    @GetMapping("/id/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @Autowired
    private ClientService clientService;
}
