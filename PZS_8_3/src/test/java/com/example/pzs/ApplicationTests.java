package com.example.pzs;

import com.example.pzs.config.MethodSecurityConfig;
import com.example.pzs.config.PasswordEncoderConfiguration;
import com.example.pzs.config.SecurityConfig;
import com.example.pzs.controller.ArticleController;
import com.example.pzs.controller.UserController;
import com.example.pzs.dto.request.ArticleCreateRequest;
import com.example.pzs.entity.Article;
import com.example.pzs.entity.User;
import com.example.pzs.repository.ArticleRepository;
import com.example.pzs.repository.UserRepository;
import com.example.pzs.security.JwtProvider;
import com.example.pzs.service.impl.ArticleServiceImpl;
import com.example.pzs.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Set;

import static com.example.pzs.security.JwtTokenAuthenticationFilter.HEADER_PREFIX;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureCache
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@ImportAutoConfiguration(
        classes = {
                UserServiceImpl.class,
                ArticleServiceImpl.class,
                PasswordEncoderConfiguration.class,
                JwtProvider.class,
                SecurityConfig.class,
                MethodSecurityConfig.class,
        }
)
@WebMvcTest(value = {
        UserController.class,
        ArticleController.class,
})
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtProvider provider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void getOneUser() throws Exception {
        userRepository.save(User.builder()
                .username("Mihail")
                .password(passwordEncoder.encode("1234"))
                .build()).getId();
        var id = getSomeUserId();
        mvc.perform(get("/api/users/{id}", id))
                .andExpect(status().isOk());
    }

    long getSomeUserId() {
        return userRepository.findAll().get(0).getId();
    }

    @BeforeEach
    void createUsers() {
        articleRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void createArticle() throws Exception {
        userRepository.save(User.builder()
                .username("Mihail")
                .password(passwordEncoder.encode("1234"))
                .build()).getId();
        var userId = getSomeUserId();
        var request = new ArticleCreateRequest();
        request.setTitle("Title 2");
        request.setText("Text");
        var token = provider.generateAccessToken(userId);
        var result = mvc.perform(post("/api/articles")
                        .content(objectMapper.writeValueAsString(request))
                        .header(AUTHORIZATION, HEADER_PREFIX + token)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        var articleId = objectMapper.readTree(result.getResponse().getContentAsString()).get("id").asLong();
        mvc.perform(get("/api/articles/{id}", articleId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Article.builder()
                        .id(articleId)
                        .owner(userRepository.getReferenceById(userId))
                        .text(request.getText())
                        .title(request.getTitle())
                        .build())));
        assertEquals(getOneUser(userId).get("articles").size(), 1);
    }

    JsonNode getOneUser(long userId) throws Exception {
        return objectMapper.readTree(mvc.perform(get("/api/users/{id}", userId))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

    @Test
    void createAndDeleteArticle() throws Exception {
        userRepository.save(User.builder()
                .username("Mihail")
                .password(passwordEncoder.encode("1234"))
                .build()).getId();
        var userId = getSomeUserId();
        var request = new ArticleCreateRequest();
        request.setTitle("Title 3");
        request.setText("Text");
        var token = provider.generateAccessToken(userId);
        var result = mvc.perform(post("/api/articles")
                        .content(objectMapper.writeValueAsString(request))
                        .header(AUTHORIZATION, HEADER_PREFIX + token)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(getOneUser(userId).get("articles").size(), 1);
        var articleId = objectMapper.readTree(result.getResponse().getContentAsString()).get("id").asInt();
        mvc.perform(get("/api/articles/{id}", articleId))
                .andExpect(status().isOk());
        mvc.perform(delete("/api/articles/{id}", articleId)
                        .header(AUTHORIZATION, HEADER_PREFIX + token))
                .andExpect(status().isOk());
        mvc.perform(get("/api/articles/{id}", articleId))
                .andExpect(status().is(404));
        assertEquals(getOneUser(userId).get("articles").size(), 0);
    }

    @Test
    void deleteUserWithArticle() throws Exception {
        var userId = userRepository.save(User.builder()
                .username("Mihail")
                .password(passwordEncoder.encode("1234"))
                .articles(Set.of())
                .build()).getId();
        var request = new ArticleCreateRequest();
        request.setTitle("Title");
        request.setText("Text");
        var token = provider.generateAccessToken(userId);
        var articleId = createOneArticle(token, request).get("id").asInt();
        assertEquals(getOneUser(userId).get("articles").size(), 1);
        deleteOneArticle(token, articleId);
        assertEquals(getOneUser(userId).get("articles").size(), 0);
    }

    JsonNode createOneArticle(String token, ArticleCreateRequest request) throws Exception {
        return objectMapper.readTree(mvc.perform(post("/api/articles", request)
                        .content(objectMapper.writeValueAsString(request))
                        .header(AUTHORIZATION, HEADER_PREFIX + token)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

    ResultActions deleteOneArticle(String token, long articleId) throws Exception {
        return mvc.perform(delete("/api/articles/{id}", articleId)
                        .header(AUTHORIZATION, HEADER_PREFIX + token))
                .andExpect(status().isOk());
    }

    JsonNode getOneArticle(long articleId) throws Exception {
        return objectMapper.readTree(mvc.perform(get("/api/articles/{id}", articleId))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

    @Test
    void createAndDeleteArticleNoOwner() throws Exception {
        var mihailId = userRepository.save(User.builder()
                .username("Mihail")
                .password(passwordEncoder.encode("1234"))
                .build()).getId();
        var nikitaId = userRepository.save(User.builder()
                .username("Nikita")
                .password(passwordEncoder.encode("1234"))
                .build()).getId();
        var mihailToken = provider.generateAccessToken(mihailId);
        var nikitaToken = provider.generateAccessToken(nikitaId);
        var request = new ArticleCreateRequest();
        request.setTitle("Title 3");
        request.setText("Text");
        var result = mvc.perform(post("/api/articles")
                        .content(objectMapper.writeValueAsString(request))
                        .header(AUTHORIZATION, HEADER_PREFIX + nikitaToken)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        var articleId = objectMapper.readTree(result.getResponse().getContentAsString()).get("id").asInt();
        mvc.perform(delete("/api/articles/{id}", articleId))
                .andExpect(status().isForbidden());
        mvc.perform(delete("/api/articles/{id}", articleId)
                        .header(AUTHORIZATION, HEADER_PREFIX + mihailToken))
                .andExpect(status().isForbidden());
        mvc.perform(delete("/api/articles/{id}", articleId)
                        .header(AUTHORIZATION, HEADER_PREFIX + nikitaToken))
                .andExpect(status().isOk());
        mvc.perform(get("/api/articles/{id}", articleId))
                .andExpect(status().is(404));
    }

}
