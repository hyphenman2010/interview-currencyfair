package org.ivanman.interview.order;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository class for <code>Trade</code> domain objects */

public interface OrderResultRepository extends Repository<OrderResult, Integer> {

	@Transactional(readOnly = true)
	Collection<OrderResult> findAll() throws DataAccessException;
	
	void save(OrderResult orderResult);

}
