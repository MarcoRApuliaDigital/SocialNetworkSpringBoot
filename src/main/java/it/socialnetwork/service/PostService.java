package it.socialnetwork.service;

import it.socialnetwork.dto.ContenutiPostDTO;
import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.entity.ContenutiPostEntity;
import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.entity.UtentiEntity;
import it.socialnetwork.repository.ContenutiPostRepository;
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
    private final ContenutiPostRepository contenutiPostRepository;
    private final UtentiRepository utentiRepository;


    // Crea un nuovo post con contenuti
    @Transactional
    public PostDTO creaPost(Long idUtente, PostDTO postDTO) {
        UtentiEntity utente = utentiRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        PostEntity post = new PostEntity();
        post.setUtente(utente);
        post.setDataPubblicazione(LocalDateTime.now());
        post.setNumeroLike(0);
        post.setNumeroCondivisioni(0);
        postRepository.save(post);

        // salva contenuti
        List<ContenutiPostEntity> contenuti = new ArrayList<>();
        for (ContenutiPostDTO c : postDTO.getContenuti()) {
            ContenutiPostEntity cp = new ContenutiPostEntity();
            cp.setPost(post);
            cp.setTipoContenuto(c.getTipoContenuto());
            cp.setContenuto(c.getContenuto());
            contenuti.add(cp);
        }
        contenutiPostRepository.saveAll(contenuti);

        // prepara DTO da restituire
        postDTO.setIdPost(post.getIdPost());
        postDTO.setIdUtente(idUtente);
        postDTO.setNomeUtente(utente.getNome() + " " + utente.getCognome());
        return postDTO;
    }

    //Trasforma una lista di PostEntity in PostDTO

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

            List<ContenutiPostDTO> contenutiDTO = new ArrayList<>();
            for (ContenutiPostEntity cp : post.getContenuti()) {
                ContenutiPostDTO cDTO = new ContenutiPostDTO();
                cDTO.setTipoContenuto(cp.getTipoContenuto());
                cDTO.setContenuto(cp.getContenuto());
                contenutiDTO.add(cDTO);
            }
            dto.setContenuti(contenutiDTO);
            feed.add(dto);
        }
        return feed;
    }
}
