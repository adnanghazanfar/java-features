package com.learning.graphql.graphqlapp.controller;

import com.learning.graphql.graphqlapp.controller.model.BookInput;
import com.learning.graphql.graphqlapp.model.Author;
import com.learning.graphql.graphqlapp.model.Book;
import com.learning.graphql.graphqlapp.model.Review;
import com.learning.graphql.graphqlapp.repo.BookRepository;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

  private final BookRepository bookRepository;

  @QueryMapping
  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @SchemaMapping
  public Author author(Book book) {
    return book.getAuthor();
  }

  @BatchMapping (field = "reviews", typeName = "Book")
  public Map<Book, List<Review>> reviews(List<Book> books) {
    return books.stream()
        .collect(Collectors.toMap(book-> book, book-> book.getReviews()));
  }

  @MutationMapping
  public Book addBook(@Argument BookInput bookInput) {
    Book book = new Book(bookInput.title(), bookInput.pages(), new Author(bookInput.author()));
    return bookRepository.save(book);
  }

  @MutationMapping
  public List<Book> addBooks(@Argument List<BookInput> bookInputs) {
    return bookInputs.stream().map(bookInput -> {
      Book book = new Book(bookInput.title(), bookInput.pages(), new Author(bookInput.author()));
      return bookRepository.save(book);
    }).toList();
  }

}