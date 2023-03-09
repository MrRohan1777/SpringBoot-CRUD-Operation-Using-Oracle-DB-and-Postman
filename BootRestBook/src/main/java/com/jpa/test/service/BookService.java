package com.jpa.test.service;

import java.util.List;

import com.jpa.test.entities.Author;
import com.jpa.test.entities.BookEntity;

public interface BookService {

	public List<BookEntity> getAllBook();

	BookEntity getBookById(int id);

	BookEntity addBook(BookEntity book);

	void deleteBook(int bid);

	void updateBook(BookEntity be, int bkId);

	void deleteAllBook();

}
