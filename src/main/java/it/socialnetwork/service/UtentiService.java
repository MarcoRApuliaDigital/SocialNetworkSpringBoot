package it.socialnetwork.service;

import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.entity.UtentiEntity;
import it.socialnetwork.mapper.UtentiMapper;
import it.socialnetwork.repository.UtentiRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtentiService {

    private final UtentiRepository utentiRepository;
    private final UtentiMapper utentiMapper;


    @Transactional
    public UtentiDTO registraUtente(UtentiDTO utentiDTO) {
        UtentiEntity utenteEntity = utentiMapper.toEntity(utentiDTO);

        utenteEntity.setDataCreazione(LocalDateTime.now());

        UtentiEntity salvato = utentiRepository.save(utenteEntity);

        return utentiMapper.toDto(salvato);
    }

    // Login: controlla username e password
    public Optional<UtentiDTO> login(String email, String password) {
        return utentiRepository.findByEmail(email)
                .filter(utente -> utente.getPassword().equals(password))
                .map(utentiMapper::toDto);
    }

    // Trova un utente per ID
    public Optional<UtentiDTO> trovaUtente(Long idUtente) {
        return utentiRepository.findById(idUtente)
                .map(utentiMapper::toDto);
    }

    // Elimina un utente per ID
    @Transactional
    public boolean eliminaUtente(Long idUtente) {
        if (!utentiRepository.existsById(idUtente)) {
            return false;
        }

        utentiRepository.deleteById(idUtente);
        return true;
    }
}