package com.fbedir.book.model;

import com.fbedir.author.model.Author;

public record Book(Long id, String name, Integer quantity, Author author) {

}
