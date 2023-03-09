package com.jpa.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.stereotype.Component;
import com.jpa.test.dao.BookRepository;
import com.jpa.test.entities.Author;
import com.jpa.test.entities.BookEntity;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bRepository;
	BookEntity book;

	/*
	 * all commented code for fetching data from the list
	 */

//	private static List<BookEntity> l=new ArrayList<>();
//	
//	static {
//		l.add(new BookEntity(101,"java","xyz"));
//		l.add(new BookEntity(102,"python","abc"));
//		l.add(new BookEntity(103,".net","pqr"));
//	}
//	Get All Book ....................................
//	public List<BookEntity> getAllBook() {
//		return l;
//	}

	/**
	 * get allbooks
	 */
	public List<BookEntity> getAllBook() {
		List<BookEntity> list = (List<BookEntity>) this.bRepository.findAll();
		return list;
	}

	/**
	 */
	public BookEntity getBookById(int id) {

		try {
//			book=l.stream().filter(e -> e.getId()==id).findFirst().get();
			book = this.bRepository.findById(id);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return book;
	}

	/*
	 * adding books
	 */
	public BookEntity addBook(BookEntity book) {

//		l.add(book);

		BookEntity result = bRepository.save(book);
		return result;
	}

	/*
	 * Deleting book
	 */
	public void deleteBook(int bid) {
//		l=l.stream().filter(e -> e.getId()!=bid).collect(Collectors.toList());

		bRepository.deleteById(bid);
	}

	/*
	 * update book
	 */
	public void updateBook(BookEntity be, int bkId) {

//		l= l.stream().map(e->{
//			if(e.getId()==bkId) {
//				e.setTitle(be.getTitle());
//				e.setAuthor(be.getAuthor());
//			}
//			return e;
//			 
//		}).collect(Collectors.toList());

		be.setId(bkId);
		bRepository.save(be);

	}

	/*
	 * delete all books
	 */
	public void deleteAllBook() {
		bRepository.deleteAll();
	}

}
