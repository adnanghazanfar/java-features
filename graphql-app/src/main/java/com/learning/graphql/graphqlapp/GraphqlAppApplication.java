package com.learning.graphql.graphqlapp;

import com.learning.graphql.graphqlapp.model.Author;
import com.learning.graphql.graphqlapp.model.Book;
import com.learning.graphql.graphqlapp.model.Review;
import com.learning.graphql.graphqlapp.repo.BookRepository;
import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(BookRepository bookRepository) {
		return args -> {
			Book book = new Book("Reactive Spring", 484, new Author("Josh Long"));
			Review review = new Review("Great book!", "I really enjoyed this book!");
			book.setReviews(Collections.singletonList(review));
			bookRepository.save(book);
		};
	}

}
