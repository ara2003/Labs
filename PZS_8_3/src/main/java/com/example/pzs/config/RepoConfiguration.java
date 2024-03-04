package com.example.pzs.config;

import com.example.pzs.entity.Article;
import com.example.pzs.entity.User;
import com.example.pzs.repository.ArticleRepository;
import com.example.pzs.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
public class RepoConfiguration {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    private final PasswordEncoder passwordEncoder;

    private final ObjectMapper objectMapper;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
//        articleRepository.deleteAll();
//        userRepository.deleteAll();
        final var arseny = userRepository.findByUsername("Arseny").orElseGet(() -> {
            var m = new User();
            m.setUsername("Arseny");
            m.setPassword(passwordEncoder.encode("1234"));
            return userRepository.save(m);
        });
        final var maksim = userRepository.findByUsername("Maksim").orElseGet(() -> {
            var m = new User();
            m.setUsername("Maksim");
            m.setPassword(passwordEncoder.encode("1234"));
            return userRepository.save(m);
        });
        final var nikita = userRepository.findByUsername("Nikita").orElseGet(() -> {
            var m = new User();
            m.setUsername("Nikita");
            m.setPassword(passwordEncoder.encode("1234"));
            return userRepository.save(m);
        });
        final var title1 = articleRepository.findByTitle("Title 1").orElseGet(() -> {
            var m = new Article();
            m.setTitle("Title 1");
            m.setText("Text");
            m.setOwner(arseny);
            return articleRepository.save(m);
        });
        final var title2 = articleRepository.findByTitle("Title 2").orElseGet(() -> {
            var m = new Article();
            m.setTitle("Title 2");
            m.setText("Text");
            m.setOwner(maksim);
            return articleRepository.save(m);
        });
    }

}
