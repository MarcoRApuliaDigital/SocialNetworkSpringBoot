package it.socialnetwork.dto;

import it.socialnetwork.entity.PostEntity;
import lombok.Data;

@Data
public class ContenutiPostDTO {

    private Long idContenuto;
    private PostDTO post;
    private String tipoContenuto; // testo, immagine, video
    private String contenuto;      // testo o URL
}