package it_schoolkg.sall_services.services.impl;

import it_schoolkg.sall_services.Mappers.ProductMapper;
import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import it_schoolkg.sall_services.Models.entities.Product;
import it_schoolkg.sall_services.exception.ErrorResponse;
import it_schoolkg.sall_services.repository.dao.ProductRepo;
import it_schoolkg.sall_services.services.ProductService;
import it_schoolkg.sall_services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> saveProduct(String token, ProductDTO productDTO) {
         ResponseEntity<?> responseEntity =
                 userService
                         .verifyLogin(token);
         if (!responseEntity.getStatusCode().equals(HttpStatus.OK)){
             return responseEntity;
         }
        Product product = ProductMapper
                .INSTANCE
                .mapToProduct(productDTO);
         if (Objects.isNull(productRepo.findByNameBarcode(product.getName(),product.getBarcode()))){
            productRepo.save(product);
         }else {
             return new ResponseEntity<>(
                     new ErrorResponse("Такой товар уже существует!",null)
                     ,HttpStatus.CONFLICT);
         }return ResponseEntity.ok(
                 "Товар успешно сохранен! " +
                         ProductMapper
                                 .INSTANCE.mapToProductDto(product));
    }

    @Override
    public ResponseEntity<?> updateProduct(String token, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> getProductByBarcode(String token, String barcode) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllProducts(String token) {
        return null;
    }
}
