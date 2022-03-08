package it_schoolkg.sall_services.repository.dao;

import it_schoolkg.sall_services.Models.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Long> {
}
