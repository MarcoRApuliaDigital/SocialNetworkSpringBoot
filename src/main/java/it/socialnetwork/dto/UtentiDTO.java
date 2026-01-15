package it.socialnetwork.dto;

import it.socialnetwork.enums.SessoEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UtentiDTO {

    private Long idUtente;
    private String nome;
    private String cognome;
    private String email;
    private SessoEnum sesso;
    private LocalDateTime dataCreazione;
    private LocalDate dataNascita; // String per JSON
    private CredenzialiDTO credenziali;
    private List<PostDTO> post;
    private List<CommentiDTO> commenti;
}
