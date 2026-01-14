package it.socialnetwork.dto;

import lombok.Data;

@Data
public class UtentiDTO {

    private Long idUtente;
    private String nome;
    private String cognome;
    private String email;
    private String sesso;
    private String dataNascita; // String per JSON
}
