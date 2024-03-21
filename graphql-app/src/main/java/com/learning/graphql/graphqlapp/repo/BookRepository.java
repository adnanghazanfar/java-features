package com.learning.graphql.graphqlapp.repo;

import com.learning.graphql.graphqlapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {}