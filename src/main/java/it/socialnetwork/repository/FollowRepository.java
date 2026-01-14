package it.socialnetwork.repository;

import it.socialnetwork.entity.FollowEntity;
import it.socialnetwork.entity.UtentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, Long> {

    // Lista di utenti che seguo
    List<FollowEntity> findByFollower(UtentiEntity follower);

    // Lista di utenti che mi seguono
    List<FollowEntity> findBySeguendo(UtentiEntity seguendo);

    // Controlla se un follow esiste
    Optional<FollowEntity> findByFollowerAndSeguendo(UtentiEntity follower, UtentiEntity seguendo);
}