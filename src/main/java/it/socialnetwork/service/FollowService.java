package it.socialnetwork.service;

import it.socialnetwork.dto.FollowDTO;
import it.socialnetwork.entity.FollowEntity;
import it.socialnetwork.entity.UtentiEntity;
import it.socialnetwork.repository.FollowRepository;
import it.socialnetwork.repository.UtentiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final UtentiRepository utentiRepository;


     // Segui un utente

    public FollowDTO seguiUtente(Long followerId, Long seguendoId) {
        UtentiEntity follower = utentiRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Utente follower non trovato"));
        UtentiEntity seguendo = utentiRepository.findById(seguendoId)
                .orElseThrow(() -> new RuntimeException("Utente seguito non trovato"));

        // Controlla se già esiste la relazione follow
        if(followRepository.findByFollowerAndSeguendo(follower, seguendo).isPresent()) {
            throw new RuntimeException("Utente già seguito");
        }

        FollowEntity follow = new FollowEntity();
        follow.setFollower(follower);
        follow.setSeguendo(seguendo);
        follow.setDataCreazione(LocalDateTime.now());

        followRepository.save(follow);

        FollowDTO dto = new FollowDTO();
        dto.setIdFollow(follow.getIdFollow());
        dto.setFollowerId(followerId);
        dto.setFollowerNome(follower.getNome() + " " + follower.getCognome());
        dto.setSeguendoId(seguendoId);
        dto.setSeguendoNome(seguendo.getNome() + " " + seguendo.getCognome());
        dto.setDataCreazione(follow.getDataCreazione().toString());
        return dto;
    }


     // Lista di utenti che seguo

    public List<FollowDTO> listaFollowing(Long idUtente) {
        UtentiEntity utente = utentiRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        List<FollowEntity> followingList = followRepository.findByFollower(utente);
        List<FollowDTO> dtoList = new ArrayList<>();

        for (FollowEntity f : followingList) {
            FollowDTO dto = new FollowDTO();
            dto.setIdFollow(f.getIdFollow());
            dto.setFollowerId(f.getFollower().getIdUtente());
            dto.setFollowerNome(f.getFollower().getNome() + " " + f.getFollower().getCognome());
            dto.setSeguendoId(f.getSeguendo().getIdUtente());
            dto.setSeguendoNome(f.getSeguendo().getNome() + " " + f.getSeguendo().getCognome());
            dto.setDataCreazione(f.getDataCreazione().toString());
            dtoList.add(dto);
        }

        return dtoList;
    }


     // Lista di utenti che mi seguono

    public List<FollowDTO> listaFollowers(Long idUtente) {
        UtentiEntity utente = utentiRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        List<FollowEntity> followersList = followRepository.findBySeguendo(utente);
        List<FollowDTO> dtoList = new ArrayList<>();

        for (FollowEntity f : followersList) {
            FollowDTO dto = new FollowDTO();
            dto.setIdFollow(f.getIdFollow());
            dto.setFollowerId(f.getFollower().getIdUtente());
            dto.setFollowerNome(f.getFollower().getNome() + " " + f.getFollower().getCognome());
            dto.setSeguendoId(f.getSeguendo().getIdUtente());
            dto.setSeguendoNome(f.getSeguendo().getNome() + " " + f.getSeguendo().getCognome());
            dto.setDataCreazione(f.getDataCreazione().toString());
            dtoList.add(dto);
        }

        return dtoList;
    }
}