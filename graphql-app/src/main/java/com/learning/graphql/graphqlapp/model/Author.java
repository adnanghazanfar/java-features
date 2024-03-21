package com.learning.graphql.graphqlapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // Constructors, getters, and setters
    public Author(String name) {
        this.name = name;
    }
}