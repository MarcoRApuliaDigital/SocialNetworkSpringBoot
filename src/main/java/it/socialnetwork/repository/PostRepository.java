package it.socialnetwork.repository;

import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.entity.UtentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    // Trova tutti i post di un utente
    List<PostEntity> findByUtenteOrderByDataPubblicazioneDesc(UtentiEntity utente);
}