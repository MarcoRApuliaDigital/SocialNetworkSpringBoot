package it.socialnetwork.dto;

import it.socialnetwork.enums.SessoEnum;
import lombok.Data;

@Data
public class UtentiDTO {

    private Long idUtente;
    private String nome;
    private String cognome;
    private String email;
    private SessoEnum sesso;
    private String dataNascita; // String per JSON
}
