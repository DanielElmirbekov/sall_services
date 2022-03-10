package it_schoolkg.sall_services.controllers;

import it_schoolkg.sall_services.Models.dtos.PriceDTO;
import it_schoolkg.sall_services.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/save")
    public ResponseEntity<?>savePrice(@RequestHeader String token , @RequestBody PriceDTO priceDTO){
        return priceService.savePrice(token,priceDTO);
    }
    @PostMapping("/getByProduct")
    public ResponseEntity<?>getByProduct(@RequestHeader String token , @RequestBody PriceDTO productDTO){
        return priceService.getPriceByProduct(token,productDTO);
    }
    @GetMapping("/getAllPrices")
    public ResponseEntity<?>getAllPrices(@RequestHeader String token){
        return priceService.getAllPrices(token);
    }
}
