package it_schoolkg.sall_services.controllers;

import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import it_schoolkg.sall_services.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?>saveProduct(@RequestHeader String token , @RequestBody ProductDTO productDTO){
        return productService.saveProduct(token,productDTO);
    }
    @PutMapping("/update")
    public ResponseEntity<?>updateProduct(@RequestHeader String token , @RequestBody ProductDTO productDTO){
        return productService.updateProduct(token,productDTO);
    }
    @GetMapping("/getByBarcode")
    public ResponseEntity<?>getProductByBarcode(@RequestHeader String token , @RequestParam String barcode){
        return productService.getProductByBarcode(token,barcode);
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<?>getAllProducts(@RequestHeader String token){
        return productService.getAllProducts(token);
    }
}
