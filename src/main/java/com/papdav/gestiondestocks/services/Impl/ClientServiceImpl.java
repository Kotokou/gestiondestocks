package com.papdav.gestiondestocks.services.Impl;

import com.papdav.gestiondestocks.dtos.ClientDto;
import com.papdav.gestiondestocks.exceptions.EntityNotFoundException;
import com.papdav.gestiondestocks.exceptions.ErrorCodes;
import com.papdav.gestiondestocks.exceptions.InvalidEntityException;
import com.papdav.gestiondestocks.models.Client;
import com.papdav.gestiondestocks.repository.ClientRepository;
import com.papdav.gestiondestocks.services.ClientService;
import com.papdav.gestiondestocks.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("Client is not valid {}", clientDto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null){
            log.error("Client ID is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        ClientDto clientDto = ClientDto.fromEntity(client.get());
        return Optional.of(clientDto).orElseThrow(
                () -> new EntityNotFoundException(
                        "Aucun client avec l'ID = " + id + " n'est trouvé dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public ClientDto findByNom(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Nom is null");
            return null;
        }
        Optional<Client> client = clientRepository.findByNom(nom);
        ClientDto clientDto = ClientDto.fromEntity(client.get());
        return Optional.of(clientDto).orElseThrow(
                () -> new EntityNotFoundException(
                        "Aucun client avec le Nom = " + nom + " n'a été trouvé dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Client ID id null");
            return;
        }
        clientRepository.deleteById(id);

    }
}
