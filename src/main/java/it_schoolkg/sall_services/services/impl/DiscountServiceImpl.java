package it_schoolkg.sall_services.services.impl;

import it_schoolkg.sall_services.Models.dtos.DiscountDTO;
import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import it_schoolkg.sall_services.services.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public ResponseEntity<?> saveDiscount(String token, DiscountDTO discountDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> findDiscountbyProduct(String token, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllDiscount(String token) {
        return null;
    }
}
