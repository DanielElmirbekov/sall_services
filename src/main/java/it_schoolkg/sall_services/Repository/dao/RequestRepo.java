package it_schoolkg.sall_services.Repository.dao;

import it_schoolkg.sall_services.Models.entities.Code;
import it_schoolkg.sall_services.Models.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request,Long> {
    boolean countByCodeAndSucces(Code mapToCode, boolean success);
}
