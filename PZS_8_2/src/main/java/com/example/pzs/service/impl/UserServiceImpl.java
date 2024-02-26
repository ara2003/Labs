package com.example.pzs.service.impl;

import com.example.pzs.controller.advice.exception.UserNotFoundException;
import com.example.pzs.dto.request.UserReplaceRequest;
import com.example.pzs.entity.User;
import com.example.pzs.repository.UserRepository;
import com.example.pzs.service.ArticleService;
import com.example.pzs.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@AllArgsConstructor
@Component("userService")
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private ArticleService articleService;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public User getOneUser(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Collection<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        repository.findById(id).ifPresent(x -> {
            articleService.deleteArticles(x.getArticles());
            repository.delete(x);
        });
    }

    @Override
    public User replaceUser(long id, UserReplaceRequest request) {
        var user = getOneUser(id);
        var username = request.getUsername();
        if (username != null)
            user.setUsername(username);
        var password = request.getPassword();
        if (password != null)
            user.setUsername(password);
        return repository.save(user);
    }

}