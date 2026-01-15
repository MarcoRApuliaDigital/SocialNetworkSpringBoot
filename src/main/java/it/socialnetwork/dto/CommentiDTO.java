package it.socialnetwork.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentiDTO {
    private Long idCommento;
    private String contenuto;
    private UtentiDTO utente;   // chi ha scritto il commento
}