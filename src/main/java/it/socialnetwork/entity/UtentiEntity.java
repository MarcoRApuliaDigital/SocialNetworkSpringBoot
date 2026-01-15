package it.socialnetwork.entity;

import it.socialnetwork.enums.SessoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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
    private String username;
    private String password;
    private SessoEnum sessoEnum;
}