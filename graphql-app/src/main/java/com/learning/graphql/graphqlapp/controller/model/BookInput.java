package com.learning.graphql.graphqlapp.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookInput(@JsonProperty("title") String title, @JsonProperty("pages") Integer pages, @JsonProperty("author") String author) {}