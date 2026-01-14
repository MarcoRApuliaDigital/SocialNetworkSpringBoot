package it.socialnetwork.repository;

import it.socialnetwork.entity.UtentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtentiRepository extends JpaRepository<UtentiEntity, Long> {

    // Trova utente per email
    Optional<UtentiEntity> findByEmail(String email);

    // Trova utente per nome/cognome (es. ricerca semplice)
    Optional<UtentiEntity> findByNomeAndCognome(String nome, String cognome);
}
