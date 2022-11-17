package dev.danvega.controller;

import dev.danvega.model.Post;
import dev.danvega.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public record PostController(PostRepository postRepository) {

    /*
    Record are Inmutable
    Inmutable objects are easier to use, maintain, test, side-effects free, and easier to cache.
    An immutable object can't be modified after it has been created.
    Since the internal state of an immutable object remains constant in time, we can share it safely among multiple threads.
    We can also use it freely, and none of the objects referencing it will notice any difference, we can say that immutable objects are side-effects free.

    Since no modification occurs when executing a specific operation, that operation is said to be side-effect free.
    Immutable objects don't change their internal state in time, they are thread-safe and side-effects free. Because of those properties, immutable objects are also especially useful when dealing with multi-thread environments.


     */

    @GetMapping
    public List<Post> findAll() {
       return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") String id) {
        return Post.builder()
                .id(Long.parseLong(id))
                .build();
    }



}
