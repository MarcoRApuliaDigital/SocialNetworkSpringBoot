package it.socialnetwork.service;

import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.entity.UtentiEntity;
import it.socialnetwork.mapper.UtentiMapper;
import it.socialnetwork.repository.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtentiService {

    private final UtentiRepository repository;
    private final UtentiMapper mapper = UtentiMapper.INSTANCE;

    @Autowired
    public UtentiService(UtentiRepository repository) {
        this.repository = repository;
    }

    // REGISTRAZIONE
    public UtentiDTO registraUtente(UtentiDTO dto) {
        // Controllo username già esistente
        if (repository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username già esistente");
        }

        // Controllo email già esistente
        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email già esistente");
        }

        // Salvo entity
        UtentiEntity entity = mapper.toEntity(dto);
        UtentiEntity saved = repository.save(entity);

        // Ritorno DTO
        return mapper.toDTO(saved);
    }

    // LOGIN
    public UtentiDTO login(String username, String password) {
        UtentiEntity entity = repository.findByUsername(username);
        if (entity == null || !entity.getPassword().equals(password)) {
            throw new RuntimeException("Username o password errati");
        }
        return mapper.toDTO(entity);
    }

    // TROVA UTENTE PER ID
    public UtentiDTO trovaPerId(Long id) {
        Optional<UtentiEntity> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Utente non trovato");
        }
        return mapper.toDTO(optional.get());
    }

    // ELIMINA UTENTE
    public void eliminaUtente(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Utente non trovato");
        }
        repository.deleteById(id);
    }
}