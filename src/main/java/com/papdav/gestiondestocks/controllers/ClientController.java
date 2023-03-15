package com.papdav.gestiondestocks.controllers;

import com.papdav.gestiondestocks.dtos.ClientDto;
import com.papdav.gestiondestocks.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.papdav.gestiondestocks.utils.Constants.APP_ROOT;
@RestController
@RequestMapping(APP_ROOT + "/clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDto> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto getClientById(@PathVariable Integer id){
        return clientService.findById(id);
    }

    @GetMapping(value = "/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto getClientById(@PathVariable String nom){
        return clientService.findByNom(nom);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto createClient(ClientDto clientDto){
        return clientService.save(clientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        clientService.delete(id);
    }

}
