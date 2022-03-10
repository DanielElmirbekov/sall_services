package it_schoolkg.sall_services.repository.dao;

import it_schoolkg.sall_services.Models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Object findByNameBarcode(String name, String barcode);

    Product findByBarcode(String barcode);
}
