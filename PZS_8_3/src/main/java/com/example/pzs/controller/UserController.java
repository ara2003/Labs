package com.example.pzs.controller;

import com.example.pzs.dto.request.UserReplaceRequest;
import com.example.pzs.entity.User;
import com.example.pzs.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.example.pzs.controller.Util.authenticated;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public Collection<User> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getOne(@PathVariable long id) {
        return service.getOneUser(id);
    }

    @GetMapping("/users/me")
    public User getMe(Authentication authentication) {
        var user = authenticated(authentication);
        return service.getOneUser(user.getId());
    }

    @PutMapping("/users/me")
    public User replace(Authentication authentication, @RequestBody UserReplaceRequest request) {
        var user = authenticated(authentication);
        return service.replaceUser(user.getId(), request);
    }

    @DeleteMapping("/users/me")
    public void deleteOne(Authentication authentication) {
        var user = authenticated(authentication);
        service.deleteUser(user.getId());
    }

}
