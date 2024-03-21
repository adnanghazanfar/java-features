package com.learning.graphql.graphqlapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Integer pages;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private List<Review> reviews;

    // Constructors, getters, and setters
    public Book(String title, Integer pages, Author author) {
        this.title = title;
        this.pages = pages;
        this.author = author;
    }


}