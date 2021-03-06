package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.PriceDTO;
import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface PriceService {
    ResponseEntity<?> savePrice(String token, PriceDTO priceDTO);

    ResponseEntity<?> getPriceByProduct(String token, ProductDTO productDTO);

    ResponseEntity<?> getAllPrices(String token);

    double findPriceByProductForOperationDetails(ProductDTO productDTO);
}
