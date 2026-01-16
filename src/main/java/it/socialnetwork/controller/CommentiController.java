package it.socialnetwork.controller;

import it.socialnetwork.dto.CommentiDTO;
import it.socialnetwork.service.CommentiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commenti")
@RequiredArgsConstructor
public class CommentiController {

    private final CommentiService commentiService;

    // Aggiungi commento
    @PostMapping("/{idPost}/{idUtente}")
    public ResponseEntity<CommentiDTO> aggiungiCommento(@PathVariable Long idPost,
                                                        @PathVariable Long idUtente,
                                                        @RequestBody CommentiDTO commentiDTO) {
        CommentiDTO creato = commentiService.aggiungiCommento(idPost, idUtente, commentiDTO);
        return ResponseEntity.ok(creato);
    }

    // Lista commenti di un post
    @GetMapping("/{idPost}")
    public ResponseEntity<List<CommentiDTO>> listaCommenti(@PathVariable Long idPost) {
        List<CommentiDTO> commenti = commentiService.getCommentiPost(idPost);
        return ResponseEntity.ok(commenti);
    }

    // Elimina commento
    @DeleteMapping("delete/{idCommento}")
    public ResponseEntity<Void> eliminaCommento(@PathVariable Long idCommento) {
        boolean eliminato = commentiService.eliminaCommento(idCommento);

        return eliminato
                ? ResponseEntity.noContent().build()   // 204
                : ResponseEntity.notFound().build();   // 404
    }
}