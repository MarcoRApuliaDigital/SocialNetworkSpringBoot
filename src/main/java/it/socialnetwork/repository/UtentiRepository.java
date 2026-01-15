package it.socialnetwork.repository;

import it.socialnetwork.entity.UtentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtentiRepository extends JpaRepository<UtentiEntity, Long> {

    // Ricerca utente per email
    Optional<UtentiEntity> findByEmail(String email);

    // Ricerca utenti per nome e cognome
    List<UtentiEntity> findByNomeAndCognome(String nome, String cognome);
}
