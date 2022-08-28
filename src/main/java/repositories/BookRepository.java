package repositories;

import domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scb on 8/27/22.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}