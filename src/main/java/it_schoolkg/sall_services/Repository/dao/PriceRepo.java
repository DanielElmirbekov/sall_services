package it_schoolkg.sall_services.Repository.dao;

import it_schoolkg.sall_services.Models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
}
