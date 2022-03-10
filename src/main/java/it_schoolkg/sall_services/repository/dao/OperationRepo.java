package it_schoolkg.sall_services.repository.dao;

import it_schoolkg.sall_services.Models.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepo extends JpaRepository<Operation,Long> {
    Operation findOperationById(Long id);
}
