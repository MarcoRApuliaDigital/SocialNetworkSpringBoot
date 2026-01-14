package it.socialnetwork.service;

import it.socialnetwork.dto.CredenzialiDTO;
import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.entity.CredenzialiEntity;
import it.socialnetwork.entity.UtentiEntity;
import it.socialnetwork.repository.CredenzialiRepository;
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
    private final CredenzialiRepository credenzialiRepository;
    private final UtentiMapper utentiMapper;


    // Registra un nuovo utente con le credenziali.
    // @param utentiDTO dati dell'utente
    // @param credenzialiDTO username e password
    // @return DTO dell'utente registrato con ID
    @Transactional
    public UtentiDTO registraUtente(UtentiDTO utentiDTO, CredenzialiDTO credenzialiDTO) {

        //esempio

        UtentiEntity utenteMapper = utentiMapper.toEntity(utentiDTO);

        UtentiEntity utente = new UtentiEntity();
        utente.setNome(utentiDTO.getNome());
        utente.setCognome(utentiDTO.getCognome());
        utente.setEmail(utentiDTO.getEmail());
        utente.setSesso(utentiDTO.getSesso());
        //utente.setDataNascita(LocalDate.parse(utentiDTO.getDataNascita()));
        utente.setDataCreazione(LocalDateTime.now());

        // Crea credenziali
        CredenzialiEntity credenziali = new CredenzialiEntity();
        credenziali.setUsername(credenzialiDTO.getUsername());
        credenziali.setPassword(credenzialiDTO.getPassword());
        credenziali.setUtente(utente);

        utente.setCredenziali(credenziali);

        utentiRepository.save(utenteMapper);

        utentiDTO.setIdUtente(utente.getIdUtente());
        return utentiDTO;
    }

    // Login: controlla username e password

    public Optional<UtentiDTO> login(String username, String password) {
        Optional<CredenzialiEntity> cred = credenzialiRepository.findByUsername(username);
        if (cred.isPresent() && cred.get().getPassword().equals(password)) {
            UtentiEntity u = cred.get().getUtente();
            UtentiDTO dto = new UtentiDTO();
            dto.setIdUtente(u.getIdUtente());
            dto.setNome(u.getNome());
            dto.setCognome(u.getCognome());
            dto.setEmail(u.getEmail());
            dto.setSesso(u.getSesso());
            //dto.setDataNascita(u.getDataNascita().toString());
            return Optional.of(dto);
        }
        return Optional.empty();
    }


    // Trova un utente per ID

    public Optional<UtentiDTO> trovaUtente(Long idUtente) {
        Optional<UtentiEntity> utenteOpt = utentiRepository.findById(idUtente);
        if (!utenteOpt.isPresent()) return Optional.empty();

        UtentiEntity u = utenteOpt.get();
        UtentiDTO dto = new UtentiDTO();
        dto.setIdUtente(u.getIdUtente());
        dto.setNome(u.getNome());
        dto.setCognome(u.getCognome());
        dto.setEmail(u.getEmail());
        dto.setSesso(u.getSesso());
       // dto.setDataNascita(u.getDataNascita().toString());
        return Optional.of(dto);
    }
}
