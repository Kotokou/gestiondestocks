package com.papdav.gestiondestocks.controllers;

import com.papdav.gestiondestocks.dtos.EntrepriseDto;
import com.papdav.gestiondestocks.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.papdav.gestiondestocks.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/entreprises")
public class EntrepriseController {

    private EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService){
        this.entrepriseService = entrepriseService;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EntrepriseDto> getAllEntreprises(){
        return entrepriseService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrepriseDto getEntrepriseById(@PathVariable Integer id){
        return entrepriseService.findById(id);
    }

    @GetMapping(value = "/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrepriseDto getEntrepriseByNom(@PathVariable String nom){
        return entrepriseService.findByNom(nom);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrepriseDto createEntreprise(@RequestBody EntrepriseDto entrepriseDto){
        return entrepriseService.save(entrepriseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        entrepriseService.delete(id);
    }
}
