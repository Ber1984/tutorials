package dev.danvega;

import dev.danvega.model.Post;
import dev.danvega.model.User;
import dev.danvega.repository.PostRepository;
import dev.danvega.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@SpringBootApplication
public class JwtJpaAuthentication {
    public static void main(String[] args) {
        SpringApplication.run(JwtJpaAuthentication.class);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, PasswordEncoder passwordEncoder) {
        return args -> {
            posts.save(new Post("Hello world", "hello-word", "Welcome to my blog", "test", Instant.now()));
            users.save(new User("user", passwordEncoder.encode("123"), "ROLE_USER"));
            users.save(new User("admin", passwordEncoder.encode("123"), "ROLE_USER, ROLE_ADMIN"));
        };
    }
}