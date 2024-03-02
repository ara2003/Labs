package com.example.pzs.service;

import com.example.pzs.dto.request.UserReplaceRequest;
import com.example.pzs.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public interface UserService extends UserDetailsService {

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    User getOneUser(long id);

    Collection<User> getAllUsers();

    void deleteUser(long id);

    User replaceUser(long id, UserReplaceRequest request);

}
