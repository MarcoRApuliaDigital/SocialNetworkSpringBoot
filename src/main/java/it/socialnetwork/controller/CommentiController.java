package it.socialnetwork.controller;

import it.socialnetwork.dto.CommentiDTO;
import it.socialnetwork.service.CommentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commenti")
public class CommentiController {

    private final CommentiService commentiService;

    @Autowired
    public CommentiController(CommentiService commentiService) {
        this.commentiService = commentiService;
    }

    // AGGIUNGI COMMENTO A UN POST
    @PostMapping("/aggiungi/{postId}")
    public ResponseEntity<CommentiDTO> aggiungiCommento(@PathVariable Long postId,
                                                        @RequestBody CommentiDTO commentoDTO) {
        CommentiDTO saved = commentiService.aggiungiCommento(commentoDTO, postId);
        return ResponseEntity.ok(saved);
    }

    // ELIMINA COMMENTO
    @DeleteMapping("/{idCommento}")
    public ResponseEntity<String> eliminaCommento(@PathVariable Long idCommento) {
        commentiService.eliminaCommento(idCommento);
        return ResponseEntity.ok("Commento eliminato con successo");
    }

    // TROVA TUTTI I COMMENTI DI UN POST
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentiDTO>> trovaCommentiPerPost(@PathVariable Long postId) {
        List<CommentiDTO> commenti = commentiService.findByPostId(postId);
        return ResponseEntity.ok(commenti);
    }
}