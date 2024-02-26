package com.example.pzs;

import com.example.pzs.config.PasswordEncoderConfiguration;
import com.example.pzs.config.SecurityConfig;
import com.example.pzs.dto.request.SignUserRequest;
import com.example.pzs.entity.User;
import com.example.pzs.repository.ArticleRepository;
import com.example.pzs.repository.CommentRepository;
import com.example.pzs.repository.UserRepository;
import com.example.pzs.security.JwtProvider;
import com.example.pzs.service.AuthService;
import com.example.pzs.service.impl.ArticleServiceImpl;
import com.example.pzs.service.impl.AuthServiceImpl;
import com.example.pzs.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = {
        AuthServiceImpl.class,
        ArticleServiceImpl.class,
        UserServiceImpl.class,
        JwtProvider.class,
        SecurityConfig.class,
        PasswordEncoderConfiguration.class,
})
@TestPropertySource("classpath:application-test.properties")
public class AuthServiceTest {

    @Autowired
    private AuthService service;
    @Autowired
    private JwtProvider provider;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CommentRepository commentRepository;
    @MockBean
    private ArticleRepository articleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void signin() {
        var v1 = User.builder().id(1L).username("Mihail").password(passwordEncoder.encode("1234")).build();
        Mockito.when(userRepository.findByUsername("Mihail")).thenReturn(Optional.of(v1));
        var tokens = service.signin(SignUserRequest.builder()
                .username("Mihail")
                .password("1234")
                .build());
        var accessId = provider.getAccessId(tokens.getAccessToken());
        var refreshId = provider.getRefreshId(tokens.getRefreshToken());
        assertEquals(accessId, 1L);
        assertEquals(refreshId, 1L);
    }

    @Test
    void refreshToken() throws InterruptedException {
        var password = "1234";
        var v1 = User.builder().id(1L).username("Mihail").password(passwordEncoder.encode(password)).build();
        Mockito.when(userRepository.findByUsername(v1.getUsername())).thenReturn(Optional.of(v1));
        Mockito.when(userRepository.findById(v1.getId())).thenReturn(Optional.of(v1));
        var tokens = service.signin(SignUserRequest.builder()
                .username(v1.getUsername())
                .password(password)
                .build());
        Thread.sleep(1000);
        var newToken = service.refreshToken(tokens.getRefreshToken());
        assertNotEquals(newToken, tokens.getAccessToken());
    }

}