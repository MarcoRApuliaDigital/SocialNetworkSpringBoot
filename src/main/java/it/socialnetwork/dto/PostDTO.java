package it.socialnetwork.dto;

import lombok.Data;
import java.util.List;

@Data
public class PostDTO {

    private Long idPost;
    private Long idUtente;
    private String nomeUtente; // autore del post
    private String dataPubblicazione;
    private Integer numeroLike;
    private Integer numeroCondivisioni;
    private List<ContenutiPostDTO> contenuti;
}
