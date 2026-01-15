package it.socialnetwork.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtentiDTO {
    private Long idUtente;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private String password;
}