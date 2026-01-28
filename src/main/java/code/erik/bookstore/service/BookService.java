package code.erik.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import code.erik.bookstore.exception.ResourceNotFoundException;
import code.erik.bookstore.model.Book;
import code.erik.bookstore.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookService implements IBookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> retrieveBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);

		if (book.isPresent()) {
			return book.get();
		} else {
			String msg = "No se encontró registro con el Id: " + id;
			log.error(msg);
			throw new ResourceNotFoundException(msg);
		}
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		
		if (book.isPresent()) {
			bookRepository.deleteById(id);
		} else {
			String msg = "No se puede eliminar el registro con el Id: " + id + " ya que no se encuentra en BD";
			log.error(msg);
			throw new ResourceNotFoundException(msg);
		}
	}

}
