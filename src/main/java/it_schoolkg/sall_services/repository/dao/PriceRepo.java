package it_schoolkg.sall_services.repository.dao;

import it_schoolkg.sall_services.Models.entities.Price;
import it_schoolkg.sall_services.Models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
    List<Price> finAllByProduct(Product mapToProduct);
}
