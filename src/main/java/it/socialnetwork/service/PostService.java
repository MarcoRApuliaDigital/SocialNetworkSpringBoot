package it.socialnetwork.service;

import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.mapper.PostMapper;
import it.socialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper mapper = PostMapper.INSTANCE;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // INSERISCI UN POST
    public PostDTO inserisciPost(PostDTO dto) {
        PostEntity entity = mapper.toEntity(dto);
        entity.setDataPubblicazione(LocalDateTime.now()); // data attuale
        if (entity.getNumeroLike() == null) entity.setNumeroLike(0);
        if (entity.getNumeroCondivisioni() == null) entity.setNumeroCondivisioni(0);
        PostEntity saved = postRepository.save(entity);
        return mapper.toDTO(saved);
    }

    // TROVA POST PER ID
    public PostDTO trovaPostPerId(Long id) {
        return postRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Post non trovato"));
    }

    // TROVA TUTTI I POST
    public List<PostDTO> trovaTuttiPost() {
        return postRepository.findAll()
                .stream()
                .map(mapper::toDTO).toList();
    }

    // ELIMINA POST
    public void eliminaPost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post non trovato");
        }
        postRepository.deleteById(id);
    }
}