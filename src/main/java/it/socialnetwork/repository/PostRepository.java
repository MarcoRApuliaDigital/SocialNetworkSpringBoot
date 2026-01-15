package it.socialnetwork.repository;

import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.entity.UtentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    // Tutti i post di un utente, più recenti prima
    List<PostEntity> findByUtenteOrderByDataPubblicazioneDesc(UtentiEntity utente);
}