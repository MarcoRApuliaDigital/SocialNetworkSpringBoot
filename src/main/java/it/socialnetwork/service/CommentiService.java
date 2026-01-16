package it.socialnetwork.service;

import it.socialnetwork.dto.CommentiDTO;
import it.socialnetwork.entity.CommentiEntity;
import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.entity.UtentiEntity;
import it.socialnetwork.repository.CommentiRepository;
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
public class CommentiService {

    private final CommentiRepository commentiRepository;
    private final PostRepository postRepository;
    private final UtentiRepository utentiRepository;


    // Aggiunge un commento a un post
    @Transactional
    public CommentiDTO aggiungiCommento(Long idPost, Long idUtente, CommentiDTO commentiDTO) {
        PostEntity post = postRepository.findById(idPost)
                .orElseThrow(() -> new RuntimeException("Post non trovato"));
        UtentiEntity utente = utentiRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        CommentiEntity commento = new CommentiEntity();
        commento.setPost(post);
        commento.setUtente(utente);
        commento.setTesto(commentiDTO.getTesto());
        commento.setDataPubblicazione(LocalDateTime.now());

        commentiRepository.save(commento);

        // Trasforma entity in DTO da restituire
        commentiDTO.setIdCommento(commento.getIdCommento());
        commentiDTO.setIdPost(idPost);
        commentiDTO.setIdUtente(idUtente);
        commentiDTO.setNomeUtente(utente.getNome() + " " + utente.getCognome());
        commentiDTO.setDataPubblicazione(commento.getDataPubblicazione().toString());

        return commentiDTO;
    }


    // Recupera tutti i commenti di un post

    public List<CommentiDTO> getCommentiPost(Long idPost) {
        PostEntity post = postRepository.findById(idPost)
                .orElseThrow(() -> new RuntimeException("Post non trovato"));

        List<CommentiEntity> commenti = commentiRepository.findByPostOrderByDataPubblicazioneAsc(post);
        List<CommentiDTO> commentiDTOList = new ArrayList<>();

        for (CommentiEntity c : commenti) {
            CommentiDTO dto = new CommentiDTO();
            dto.setIdCommento(c.getIdCommento());
            dto.setIdPost(post.getIdPost());
            dto.setIdUtente(c.getUtente().getIdUtente());
            dto.setNomeUtente(c.getUtente().getNome() + " " + c.getUtente().getCognome());
            dto.setTesto(c.getTesto());
            dto.setDataPubblicazione(c.getDataPubblicazione().toString());
            commentiDTOList.add(dto);
        }

        return commentiDTOList;
    }

    // Elimina commento
    @Transactional
    public boolean eliminaCommento(Long idCommento) {
        if (!commentiRepository.existsById(idCommento)) {
            return false;
        }

        commentiRepository.deleteById(idCommento);
        return true;
    }
}