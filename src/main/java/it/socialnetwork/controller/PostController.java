package it.socialnetwork.controller;

import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // INSERISCI UN POST
    @PostMapping("/inserisci")
    public ResponseEntity<PostDTO> inserisciPost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.inserisciPost(postDTO));
    }

    // TROVA POST PER ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> trovaPostPerId(@PathVariable Long id) {
        return ResponseEntity.ok(postService.trovaPostPerId(id));
    }

    // TROVA TUTTI I POST
    @GetMapping("/tutti")
    public ResponseEntity<List<PostDTO>> trovaTuttiPost() {
        List<PostDTO> posts = postService.trovaTuttiPost();
        return ResponseEntity.ok(posts);
    }

    // ELIMINA POST
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminaPost(@PathVariable Long id) {
        postService.eliminaPost(id);
        return ResponseEntity.ok("Post eliminato con successo");
    }
}
