package com.papdav.gestiondestocks.services.Impl;

import com.papdav.gestiondestocks.dtos.EntrepriseDto;
import com.papdav.gestiondestocks.exceptions.EntityNotFoundException;
import com.papdav.gestiondestocks.exceptions.ErrorCodes;
import com.papdav.gestiondestocks.exceptions.InvalidEntityException;
import com.papdav.gestiondestocks.models.Entreprise;
import com.papdav.gestiondestocks.repository.EntrepriseRepository;
import com.papdav.gestiondestocks.services.EntrepriseService;
import com.papdav.gestiondestocks.validators.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("Entreprise is invalid {}", entrepriseDto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null){
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        EntrepriseDto entrepriseDto = EntrepriseDto.fromEntity(entreprise.get());
        return Optional.of(entrepriseDto).orElseThrow(() -> new EntityNotFoundException("Aucune entreprise avec l'ID = " + id + " n'a été trouvé dans la BDD", ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findByNom(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Entreprise name is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findByNom(nom);
        EntrepriseDto entrepriseDto = EntrepriseDto.fromEntity(entreprise.get());
        return Optional.of(entrepriseDto).orElseThrow(()-> new EntityNotFoundException("Aucune entreprise avec le Nom = " + nom + " n'a été trouvé dans la BDD", ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Entreprise ID is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
