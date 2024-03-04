package com.example.pzs.repository;

import com.example.pzs.entity.MutableBaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractJpaRepository<E extends MutableBaseEntity<ID>, ID> implements JpaRepository<E, ID> {

    protected final List<E> entities = new ArrayList<>();

    @Override
    public E save(E e) {
        e.setId(nextId());
        entities.add(e);
        return e;
    }

    protected abstract ID nextId();

    @Override
    public List<E> findAll() {
        return entities;
    }

    @Override
    public void deleteById(ID id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public Optional<E> findById(ID id) {
        return entities.stream().filter(x -> id.equals(x.getId())).findAny();
    }

    @Override
    public void delete(E e) {
        entities.remove(e);
    }

    @Override
    public void deleteAll() {
        for (E entity : entities) {
            delete(entity);
        }
    }

}
