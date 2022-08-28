package spring5webapp.repositories;

import spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by scb on 8/27/22.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}