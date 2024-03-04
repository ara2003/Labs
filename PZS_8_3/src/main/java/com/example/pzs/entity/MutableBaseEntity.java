package com.example.pzs.entity;

public interface MutableBaseEntity<ID> extends BaseEntity<ID> {

    void setId(ID id);

}
