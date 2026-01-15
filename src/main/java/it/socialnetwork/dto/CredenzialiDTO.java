package it.socialnetwork.dto;

import it.socialnetwork.entity.UtentiEntity;
import lombok.Data;

@Data
public class CredenzialiDTO {

    private String username;
    private String password;
    private UtentiDTO utente;
}
