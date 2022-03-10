package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.DiscountDTO;
import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface DiscountService {
    ResponseEntity<?> saveDiscount(String token, DiscountDTO discountDTO);

    ResponseEntity<?> findDiscountbyProduct(String token, ProductDTO productDTO);

    ResponseEntity<?> getAllDiscount(String token);

    double getDiscountByProduct(ProductDTO productDTO);
}
