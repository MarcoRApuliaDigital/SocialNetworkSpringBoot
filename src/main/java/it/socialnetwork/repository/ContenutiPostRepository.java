package it.socialnetwork.repository;

import it.socialnetwork.entity.ContenutiPostEntity;
import it.socialnetwork.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenutiPostRepository extends JpaRepository<ContenutiPostEntity, Long> {

    // Trova tutti i contenuti di un post
    List<ContenutiPostEntity> findByPost(PostEntity post);
}