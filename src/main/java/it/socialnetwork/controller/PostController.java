package it.socialnetwork.controller;

import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.entity.PostEntity;
import it.socialnetwork.service.PostService;
import it.socialnetwork.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    // Crea post
    @PostMapping("/{idUtente}")
    public ResponseEntity<PostDTO> creaPost(@PathVariable Long idUtente, @RequestBody PostDTO postDTO) {
        PostDTO creato = postService.creaPost(idUtente, postDTO);
        return ResponseEntity.ok(creato);
    }

    // Feed: tutti i post
    @GetMapping("/feed")
    public ResponseEntity<List<PostDTO>> feed() {
        List<PostEntity> posts = postRepository.findAll();
        List<PostDTO> feed = postService.getFeed(posts);
        return ResponseEntity.ok(feed);
    }

    // Elimina post
    @DeleteMapping("delete/{idPost}")
    public ResponseEntity<Void> eliminaPost(@PathVariable Long idPost) {
        boolean eliminato = postService.eliminaPost(idPost);
        return eliminato
                ? ResponseEntity.noContent().build()   // 204
                : ResponseEntity.notFound().build();   // 404
    }
}