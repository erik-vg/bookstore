package code.erik.bookstore.service;

import java.util.List;

import code.erik.bookstore.model.Book;

public interface IBookService {

	List<Book> retrieveBooks();

	Book getBook(Long id);

	Book saveBook(Book book);

	void deleteBook(Long id);

}
