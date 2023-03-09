package com.jpa.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {

	public BookEntity findById(int id);
}
