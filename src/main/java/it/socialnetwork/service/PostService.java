package it.socialnetwork.service;

import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.entity.UtentiEntity;
import it.socialnetwork.repository.PostRepository;
import it.socialnetwork.repository.UtentiRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UtentiRepository utentiRepository;

    // Crea un nuovo post
    @Transactional
    public PostDTO creaPost(Long idUtente, PostDTO postDTO) {

        UtentiEntity utente = utentiRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        PostEntity post = new PostEntity();
        post.setUtente(utente);
        post.setDataPubblicazione(LocalDateTime.now());
        post.setNumeroLike(0);
        post.setNumeroCondivisioni(0);
        post.setContenuto(postDTO.getContenuto());

        postRepository.save(post);

        // prepara DTO da restituire
        postDTO.setIdPost(post.getIdPost());
        postDTO.setIdUtente(idUtente);
        postDTO.setNomeUtente(utente.getNome() + " " + utente.getCognome());
        postDTO.setDataPubblicazione(post.getDataPubblicazione().toString());
        postDTO.setNumeroLike(post.getNumeroLike());
        postDTO.setNumeroCondivisioni(post.getNumeroCondivisioni());

        return postDTO;
    }

    // Feed
    public List<PostDTO> getFeed(List<PostEntity> posts) {

        List<PostDTO> feed = new ArrayList<>();

        for (PostEntity post : posts) {
            PostDTO dto = new PostDTO();
            dto.setIdPost(post.getIdPost());
            dto.setIdUtente(post.getUtente().getIdUtente());
            dto.setNomeUtente(post.getUtente().getNome() + " " + post.getUtente().getCognome());
            dto.setDataPubblicazione(post.getDataPubblicazione().toString());
            dto.setNumeroLike(post.getNumeroLike());
            dto.setNumeroCondivisioni(post.getNumeroCondivisioni());
            dto.setContenuto(post.getContenuto());

            feed.add(dto);
        }

        return feed;
    }
}
