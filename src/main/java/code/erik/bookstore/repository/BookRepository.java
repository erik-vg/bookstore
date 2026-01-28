package code.erik.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import code.erik.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
