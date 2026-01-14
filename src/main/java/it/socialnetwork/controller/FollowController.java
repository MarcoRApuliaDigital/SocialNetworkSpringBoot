package it.socialnetwork.controller;

import it.socialnetwork.dto.FollowDTO;
import it.socialnetwork.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    // Segui un utente
    @PostMapping("/{followerId}/{seguendoId}")
    public ResponseEntity<FollowDTO> segui(@PathVariable Long followerId,
                                           @PathVariable Long seguendoId) {
        FollowDTO dto = followService.seguiUtente(followerId, seguendoId);
        return ResponseEntity.ok(dto);
    }

    // Lista utenti che seguo
    @GetMapping("/following/{idUtente}")
    public ResponseEntity<List<FollowDTO>> following(@PathVariable Long idUtente) {
        List<FollowDTO> lista = followService.listaFollowing(idUtente);
        return ResponseEntity.ok(lista);
    }

    // Lista utenti che mi seguono
    @GetMapping("/followers/{idUtente}")
    public ResponseEntity<List<FollowDTO>> followers(@PathVariable Long idUtente) {
        List<FollowDTO> lista = followService.listaFollowers(idUtente);
        return ResponseEntity.ok(lista);
    }
}