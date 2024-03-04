package com.example.pzs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article implements MutableBaseEntity<Long> {

    private Long id;

    private String title;

    private String text;

    @JsonSerialize(using = EntityAsIdOnlySerializer.class)
    private User owner;

    @JsonSerialize(using = EntityAsIdOnlySerializer.class)
    private Set<Comment> comments = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public String toString() {
        return "Article(" + id + ")";
    }

}
