package it.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity(name = "credenziali")
@Data
@RequiredArgsConstructor
public class CredenzialiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredenziali;

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private UtentiEntity utente;
}
