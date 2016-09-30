/**
 * 
 */
package nl.bos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.bos.models.Product;

/**
 * @author x088498
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
