package it_schoolkg.sall_services.Repository.dao;

import it_schoolkg.sall_services.Models.entities.Operation_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Operation_detailRepo extends JpaRepository<Operation_detail,Long> {
}
