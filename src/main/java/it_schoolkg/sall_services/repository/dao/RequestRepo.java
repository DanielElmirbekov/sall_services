package it_schoolkg.sall_services.repository.dao;

import it_schoolkg.sall_services.Models.entities.Code;
import it_schoolkg.sall_services.Models.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request,Long> {
    int countByCodeAndSuccess(Code code, boolean success);
}
