package it_schoolkg.sall_services.Repository.dao;

import it_schoolkg.sall_services.Models.entities.Code;
import it_schoolkg.sall_services.Models.entities.User;
import it_schoolkg.sall_services.Models.enums.CodeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepo extends JpaRepository<Code,Long> {
    Code findByUserAndCodeStatus(User mapToUser, CodeStatus aNew);
}
