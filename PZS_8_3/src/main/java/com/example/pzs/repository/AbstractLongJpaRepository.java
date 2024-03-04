package com.example.pzs.repository;

import com.example.pzs.entity.MutableBaseEntity;

public abstract class AbstractLongJpaRepository<E extends MutableBaseEntity<Long>> extends AbstractJpaRepository<E, Long> {

    private Long nextId = 1L;

    @Override
    protected Long nextId() {
        return nextId++;
    }

}
