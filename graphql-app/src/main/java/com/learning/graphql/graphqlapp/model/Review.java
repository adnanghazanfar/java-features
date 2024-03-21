package com.learning.graphql.graphqlapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String comment;

    // Constructors, getters, and setters
    public Review(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }
}