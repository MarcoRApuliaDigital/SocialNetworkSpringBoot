package it.socialnetwork.dto;

import lombok.Data;

@Data
public class ContenutiPostDTO {

    private String tipoContenuto; // testo, immagine, video
    private String contenuto;      // testo o URL
}