/**
 * 
 */
package nl.bos.repositories;

import org.springframework.data.repository.CrudRepository;

import nl.bos.models.Product;

/**
 * @author x088498
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
	
}

