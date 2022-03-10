package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> saveProduct(String token, ProductDTO productDTO);

    ResponseEntity<?> getProductByBarcode(String token, String barcode);

    ResponseEntity<?> getAllProducts(String token);

    ProductDTO findProductByBarcodeForOperationDetails(String barcode);

    ResponseEntity<?> updateProduct(String token, ProductDTO productDTO);
}
