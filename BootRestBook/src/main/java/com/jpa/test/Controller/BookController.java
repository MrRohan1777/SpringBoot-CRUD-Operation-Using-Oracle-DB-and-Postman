package com.jpa.test.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entities.BookEntity;
import com.jpa.test.service.BookService;

@RestController
@RequestMapping("/req")
public class BookController {

	@Autowired
	private BookService bService;

	/**
	 * getAllBooks handler
	 * 
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<List<BookEntity>> getBooks() {
		List<BookEntity> list = this.bService.getAllBook();
		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	/**
	 * 
	 * @param id
	 * @returnss
	 */
	@GetMapping("/{bid}")
	public ResponseEntity<Object> book(@PathVariable("bid") int bid) {

		BookEntity bEntity = bService.getBookById(bid);

		if (bEntity == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return ResponseEntity.of(Optional.of(bEntity));

	}

	/**
	 * addBook Handler
	 * 
	 * @param bEntity
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity bEntity) {
		BookEntity be = null;

		try {
			BookEntity bEntity2 = this.bService.addBook(bEntity);
			System.out.println(be);
//			System.out.println(bEntity2);
			return ResponseEntity.of(Optional.of(be));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}

	}

	/**
	 * deleteBookById Handler
	 * 
	 * @param bookId
	 * @return
	 */
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {

		try {
			this.bService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	/**
	 * updateBook Handler
	 * 
	 * @param bEntity
	 * @param bid
	 * @return
	 */
	@PutMapping("/{bid}")
	public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity bEntity, @PathVariable("bid") int bid) {

		try {
			this.bService.updateBook(bEntity, bid);
			return ResponseEntity.of(Optional.of(bEntity));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	/**
	 * deleteAllBook handler
	 */
	@DeleteMapping()
	public void deleteAll() {

		bService.deleteAllBook();
	}

}
