package com.example.pzs.repository;

import com.example.pzs.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default User getByUsername(String username) {
        return findByUsername(username).get();
    }

    Optional<User> findByUsername(String username);

}
