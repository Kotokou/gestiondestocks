package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.CommandeClient;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {

    private  Integer id;
    private String code;
    private Instant dateDeCommande;
    private ClientDto client;
    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient == null) {
            return  null;
            // TODO throw Exception
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateDeCommande(commandeClient.getDateDeCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto == null){
            return  null;
            // TODO throw Exception
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateDeCommande(commandeClientDto.getDateDeCommande());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
        return commandeClient;
    }
}
