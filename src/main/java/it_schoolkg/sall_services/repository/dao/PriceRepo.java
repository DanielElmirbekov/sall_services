package it_schoolkg.sall_services.repository.dao;

import it_schoolkg.sall_services.Models.entities.Price;
import it_schoolkg.sall_services.Models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
    List<Price> finAllByProduct(Product mapToProduct);

    @Query(value = "select * from prices where product_id = ?1 and current_timestamp >start_date and current_timestamp <end_date"
    ,nativeQuery = true)

    Price findActualPrice(Product product);
}
