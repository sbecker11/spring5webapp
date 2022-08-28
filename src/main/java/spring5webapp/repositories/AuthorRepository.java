package spring5webapp.repositories;

import spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by scb on 8/27/22.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}