/**
 * 
 */
package nl.bos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nl.bos.models.ProductList;

/**
 * @author x088498
 *
 */
@Repository
public interface ProductListRepository extends CrudRepository<ProductList, Long> {
	@Query("from ProductList where name = :name")
	List<ProductList> findByName(@Param("name") String name);
}
