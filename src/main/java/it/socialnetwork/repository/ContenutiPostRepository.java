package it.socialnetwork.repository;

import it.socialnetwork.entity.ContenutiPostEntity;
import it.socialnetwork.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContenutiPostRepository extends JpaRepository<ContenutiPostEntity, Long> {

    // Trova tutti i contenuti di un post
    List<ContenutiPostEntity> findByPost(PostEntity post);
}