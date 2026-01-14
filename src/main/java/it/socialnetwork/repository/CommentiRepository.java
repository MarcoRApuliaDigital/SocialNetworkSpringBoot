package it.socialnetwork.repository;

import it.socialnetwork.entity.CommentiEntity;
import it.socialnetwork.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentiRepository extends JpaRepository<CommentiEntity, Long> {

    // Trova tutti i commenti di un post ordinati per data
    List<CommentiEntity> findByPostOrderByDataPubblicazioneAsc(PostEntity post);
}