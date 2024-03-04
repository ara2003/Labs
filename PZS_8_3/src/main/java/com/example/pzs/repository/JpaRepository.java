package com.example.pzs.repository;

import com.example.pzs.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<E extends BaseEntity<ID>, ID> {

    E save(E e);

    List<E> findAll();

    void deleteById(ID id);

    default E getReferenceById(ID id) {
        return findById(id).get();
    }

    Optional<E> findById(ID id);

    void delete(E e);

    void deleteAll();

}
