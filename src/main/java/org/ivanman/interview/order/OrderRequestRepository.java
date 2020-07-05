package org.ivanman.interview.order;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository class for <code>OrderRequest</code> domain objects */

public interface OrderRequestRepository extends Repository<OrderRequest, Integer> {

	@Transactional(readOnly = true)
	Collection<OrderRequest> findAll() throws DataAccessException;
	
	
	/**
	 * Save an {@link OrderRequest} to the data store, either inserting or updating it.
	 * @param OrderRequest the {@link OrderRequest} to save
	 */
	void save(OrderRequest orderRequest);

}
