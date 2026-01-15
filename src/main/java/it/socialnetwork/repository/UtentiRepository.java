package it.socialnetwork.repository;

import it.socialnetwork.entity.UtentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentiRepository extends JpaRepository<UtentiEntity, Long> {
    // Metodo per trovare un utente per username (utile per login)
    UtentiEntity findByUsername(String username);

    // Metodo per controllare se un username esiste già
    boolean existsByUsername(String username);

    // Metodo per controllare se un'email esiste già
    boolean existsByEmail(String email);
}