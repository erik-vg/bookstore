package code.erik.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.erik.bookstore.model.Book;
import code.erik.bookstore.service.IBookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private IBookService bookService;

	public BookController(IBookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/retrieveBooks")
	public ResponseEntity<List<Book>> retrieveBooks() {
		return new ResponseEntity<>(bookService.retrieveBooks(), HttpStatus.OK);
	}

	@PostMapping("/saveBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}

	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Book> retrieveBookById(@PathVariable Long id) {
		return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
