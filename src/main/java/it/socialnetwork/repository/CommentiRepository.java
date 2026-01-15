package it.socialnetwork.repository;

import it.socialnetwork.entity.CommentiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentiRepository extends JpaRepository<CommentiEntity, Long> {

    // Trova tutti i commenti di un post
    List<CommentiEntity> findByPostId(Long postId);
}