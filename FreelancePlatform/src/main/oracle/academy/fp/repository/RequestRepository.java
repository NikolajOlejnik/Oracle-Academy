package main.oracle.academy.fp.repository;

import main.oracle.academy.fp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository <Request, Long> {
}
