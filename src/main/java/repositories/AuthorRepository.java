package repositories;

import domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scb on 8/27/22.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}