package it.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "commenti")
@Data
@RequiredArgsConstructor
public class CommentiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommento;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private UtentiEntity utente;

    private String testo;

    private LocalDateTime dataPubblicazione;
}
