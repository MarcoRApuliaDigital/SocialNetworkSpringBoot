package it.socialnetwork.controller;

import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.service.UtentiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/utenti")
@RequiredArgsConstructor
public class UtentiController {

    private final UtentiService utentiService;

    // Registrazione

    @PostMapping("/registrazione")
    public ResponseEntity<UtentiDTO> registraUtente(@RequestBody UtentiDTO utentiDTO) {
        UtentiDTO registrato = utentiService.registraUtente(utentiDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registrato);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<UtentiDTO> login(@RequestBody UtentiDTO loginDTO) {
        Optional<UtentiDTO> utente = utentiService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return utente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    // Profilo
    @GetMapping("/{id}")
    public ResponseEntity<UtentiDTO> profilo(@PathVariable Long id) {
        Optional<UtentiDTO> utente = utentiService.trovaUtente(id);
        return utente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Elimina utente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminaUtente(@PathVariable Long id) {
        boolean eliminato = utentiService.eliminaUtente(id);

        if (eliminato) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}