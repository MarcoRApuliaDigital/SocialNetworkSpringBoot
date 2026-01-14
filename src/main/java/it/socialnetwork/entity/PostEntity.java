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
    private Integer numeroLike;
    private Integer numeroCondivisioni;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<ContenutiPostEntity> contenuti;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentiEntity> commenti;
}
