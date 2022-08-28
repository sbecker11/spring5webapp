package repositories;

import domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scb on 8/27/22.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
