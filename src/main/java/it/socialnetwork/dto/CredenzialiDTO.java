package it.socialnetwork.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CredenzialiDTO {

    private String username;
    private String password;

    @JsonIgnore // evita ciclo infinito con UtentiDTO
    private UtentiDTO utente;
}
