package code.erik.bookstore.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import code.erik.bookstore.model.Book;
import code.erik.bookstore.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataSeeder implements CommandLineRunner {
	
	private final BookRepository bookRepository;
	
	public DataSeeder(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepository.deleteAll();
		
		bookRepository.save(new Book(null, "Libro 1", 100.00));
		bookRepository.save(new Book(null, "Libro 2", 200.00));
		bookRepository.save(new Book(null, "Libro 3", 150.00));
		bookRepository.save(new Book(null, "Libro 4", 250.00));
		
		log.info("Libros iniciales cargados");

	}

}
