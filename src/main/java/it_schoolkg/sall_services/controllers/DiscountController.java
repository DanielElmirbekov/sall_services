package it_schoolkg.sall_services.controllers;

import it_schoolkg.sall_services.Models.dtos.DiscountDTO;
import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import it_schoolkg.sall_services.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/save")
    public ResponseEntity<?> saveDiscount(@RequestHeader String token , @RequestBody DiscountDTO discountDTO){
        return discountService.saveDiscount(token, discountDTO);
    }

    @PostMapping("/getByProduct")
    public ResponseEntity<?> getByProduct(@RequestHeader String token, @RequestBody ProductDTO productDTO){
        return discountService.findDiscountbyProduct(token,productDTO);
    }
    @GetMapping("/getAllDiscount")
    public ResponseEntity<?> getAllDiscount(@RequestHeader String token){
        return discountService.getAllDiscount(token);
    }
}
