package it.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "post")
@Data
@RequiredArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private UtentiEntity utente;

    private LocalDateTime dataPubblicazione;
    private Integer numeroLike = 0;
    private Integer numeroCondivisioni = 0;

    @Column(nullable = false, length = 1000)
    private String contenuto;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentiEntity> commenti;
}