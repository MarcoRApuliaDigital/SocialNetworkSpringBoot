package it.socialnetwork.controller;

import it.socialnetwork.dto.CredenzialiDTO;
import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.service.UtentiService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<UtentiDTO> registraUtente(@RequestBody UtentiDTO utentiDTO,
                                                    @RequestBody CredenzialiDTO credenzialiDTO) {
        UtentiDTO registrato = utentiService.registraUtente(utentiDTO, credenzialiDTO);
        return ResponseEntity.ok(registrato);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<UtentiDTO> login(@RequestBody CredenzialiDTO credenzialiDTO) {
        Optional<UtentiDTO> utente = utentiService.login(credenzialiDTO.getUsername(), credenzialiDTO.getPassword());
        return utente.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    // Profilo
    @GetMapping("/{id}")
    public ResponseEntity<UtentiDTO> profilo(@PathVariable Long id) {
        Optional<UtentiDTO> utente = utentiService.trovaUtente(id);
        return utente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}