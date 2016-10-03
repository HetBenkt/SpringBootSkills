/**
 * 
 */
package nl.bos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.bos.models.Person;

/**
 * @author x088498
 *
 */
@Repository
public interface VideoRepository extends CrudRepository<Person, Long> {

}
