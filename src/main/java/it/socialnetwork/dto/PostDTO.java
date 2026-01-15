package it.socialnetwork.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class PostDTO {
    private Long idPost;
    private UtentiDTO utente;                // DTO dell'utente che ha pubblicato
    private LocalDateTime dataPubblicazione;
    private Integer numeroLike;
    private Integer numeroCondivisioni;
    private String contenuto;
    private List<CommentiDTO> commenti;      // Lista di commenti
}