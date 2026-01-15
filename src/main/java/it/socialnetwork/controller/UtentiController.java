import it.socialnetwork.dto.UtentiDTO;
import it.socialnetwork.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
public class UtentiController {

    private final UtentiService service;

    @Autowired
    public UtentiController(UtentiService service) {
        this.service = service;
    }

    // REGISTRAZIONE
    @PostMapping("/registra")
    public ResponseEntity<UtentiDTO> registra(@RequestBody UtentiDTO dto) {
        UtentiDTO saved = service.registraUtente(dto);
        return ResponseEntity.ok(saved);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<UtentiDTO> login(@RequestParam String username,
                                           @RequestParam String password) {
        UtentiDTO logged = service.login(username, password);
        return ResponseEntity.ok(logged);
    }

    // TROVA UTENTE PER ID
    @GetMapping("/{id}")
    public ResponseEntity<UtentiDTO> trovaPerId(@PathVariable Long id) {
        UtentiDTO dto = service.trovaPerId(id);
        return ResponseEntity.ok(dto);
    }

    // ELIMINA UTENTE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimina(@PathVariable Long id) {
        service.eliminaUtente(id);
        return ResponseEntity.ok("Utente eliminato con successo");
    }
}