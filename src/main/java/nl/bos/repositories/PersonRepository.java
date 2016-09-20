/**
 * 
 */
package nl.bos.repositories;

import org.springframework.data.repository.CrudRepository;

import nl.bos.models.Person;

/**
 * @author x088498
 *
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

}
