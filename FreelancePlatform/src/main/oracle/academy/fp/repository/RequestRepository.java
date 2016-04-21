package main.oracle.academy.fp.repository;

import main.oracle.academy.fp.model.Request;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for <code>Request</code> domain objects. Provided by Spring Data JPA
 *
 */
public interface RequestRepository extends JpaRepository <Request, Long> {
}