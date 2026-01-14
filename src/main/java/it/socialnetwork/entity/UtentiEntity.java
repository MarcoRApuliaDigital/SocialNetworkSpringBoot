package it.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "utenti")
@Data
@RequiredArgsConstructor
public class UtentiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtente;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String sesso;
    private LocalDateTime dataCreazione;

    @OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
    private CredenzialiEntity credenziali;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<PostEntity> post;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<CommentiEntity> commenti;

    // Utenti che seguo
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<FollowEntity> following;

    // Utenti che mi seguono
    @OneToMany(mappedBy = "seguendo", cascade = CascadeType.ALL)
    private List<FollowEntity> followers;
}