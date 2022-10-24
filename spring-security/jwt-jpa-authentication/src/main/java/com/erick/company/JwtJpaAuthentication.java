package com.erick.company;

import com.erick.company.model.Post;
import com.erick.company.model.User;
import com.erick.company.repository.PostRepository;
import com.erick.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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