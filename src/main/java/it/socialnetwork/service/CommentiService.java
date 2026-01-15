package it.socialnetwork.service;

import it.socialnetwork.dto.CommentiDTO;
import it.socialnetwork.entity.CommentiEntity;
import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.mapper.CommentiMapper;
import it.socialnetwork.repository.CommentiRepository;
import it.socialnetwork.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentiService {

    private final CommentiRepository commentiRepository;
    private final PostRepository postRepository;
    private final CommentiMapper mapper = CommentiMapper.INSTANCE;

    public CommentiService(CommentiRepository commentiRepository, PostRepository postRepository) {
        this.commentiRepository = commentiRepository;
        this.postRepository = postRepository;
    }

    // AGGIUNGI COMMENTO A UN POST
    public CommentiDTO aggiungiCommento(CommentiDTO dto, Long postId) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post non trovato"));

        CommentiEntity entity = mapper.toEntity(dto);
        entity.setPost(post); // collega il commento al post

        CommentiEntity saved = commentiRepository.save(entity);
        return mapper.toDTO(saved);
    }

    // ELIMINA COMMENTO
    public void eliminaCommento(Long idCommento) {
        if (!commentiRepository.existsById(idCommento)) {
            throw new RuntimeException("Commento non trovato");
        }
        commentiRepository.deleteById(idCommento);
    }

    // TROVA TUTTI I COMMENTI DI UN POST
    public List<CommentiDTO> findByPostId(Long postId) {
        List<CommentiEntity> commentiEntities = commentiRepository.findByPostId(postId);
        return commentiEntities.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
