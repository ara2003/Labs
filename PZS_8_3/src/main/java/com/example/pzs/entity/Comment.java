package com.example.pzs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements MutableBaseEntity<Long> {

    private Long id;

    private String text;

    @JsonSerialize(using = EntityAsIdOnlySerializer.class)
    private User owner;

    @JsonSerialize(using = EntityAsIdOnlySerializer.class)
    private Article article;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public String toString() {
        return "Comment(" + id + ")";
    }

}
