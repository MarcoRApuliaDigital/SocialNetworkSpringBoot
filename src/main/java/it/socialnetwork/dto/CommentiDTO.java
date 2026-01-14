package it.socialnetwork.dto;

import lombok.Data;

@Data
public class CommentiDTO {

    private Long idCommento;
    private Long idPost;
    private Long idUtente;
    private String nomeUtente;
    private String testo;
    private String dataPubblicazione;
}
