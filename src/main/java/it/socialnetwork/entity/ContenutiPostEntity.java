package it.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity(name = "contenuti_post")
@Data
@RequiredArgsConstructor
public class ContenutiPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContenuto;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    private String tipoContenuto; // "testo", "immagine", "video"
    private String contenuto;      // testo o URL del media (?)
}