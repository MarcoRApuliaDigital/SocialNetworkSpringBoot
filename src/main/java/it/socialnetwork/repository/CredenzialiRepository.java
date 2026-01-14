package it.socialnetwork.repository;

import it.socialnetwork.entity.CredenzialiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CredenzialiRepository extends JpaRepository<CredenzialiEntity, Long> {

    // Trova credenziali per username (login)
    Optional<CredenzialiEntity> findByUsername(String username);
}
