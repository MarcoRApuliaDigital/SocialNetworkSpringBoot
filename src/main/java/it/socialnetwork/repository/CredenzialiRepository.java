package it.socialnetwork.repository;

import it.socialnetwork.entity.CredenzialiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredenzialiRepository extends JpaRepository<CredenzialiEntity, Long> {

    // Trova credenziali per username (login)
    Optional<CredenzialiEntity> findByUsername(String username);
}
