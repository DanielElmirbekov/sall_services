package it_schoolkg.sall_services.services.impl;

import it_schoolkg.sall_services.Mappers.PriceMapper;
import it_schoolkg.sall_services.Mappers.ProductMapper;
import it_schoolkg.sall_services.Models.dtos.PriceDTO;
import it_schoolkg.sall_services.Models.dtos.ProductDTO;
import it_schoolkg.sall_services.Models.entities.Price;
import it_schoolkg.sall_services.Models.entities.Product;
import it_schoolkg.sall_services.repository.dao.PriceRepo;
import it_schoolkg.sall_services.services.PriceService;
import it_schoolkg.sall_services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepo priceRepo;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> savePrice(String token, PriceDTO priceDTO) {
        ResponseEntity<?> responseEntity =
                userService
                        .verifyLogin(token);
        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)){
            return responseEntity;
        }

        List<Price> priceList =
                priceRepo
                        .finAllByProduct(
                                ProductMapper
                                        .INSTANCE
                                        .mapToProduct(
                                                priceDTO
                                                        .getProduct()));
        if (Objects.nonNull(priceList) && !priceList.isEmpty()) {
            priceList
                    .stream()
                    .filter(
                            x -> x.getStart_date().isBefore(priceDTO.getStart_date())
                                    || x.getStart_date().isAfter(priceDTO.getStart_date())
                                    && x.getEnd_date().isBefore(priceDTO.getEnd_date())
                                    || x.getEnd_date().isAfter(priceDTO.getEnd_date()))
                    .forEach(x ->
                    {
                        x.setEnd_date(LocalDateTime.now());
                        priceRepo.save(x);
                    });
        }
           Price price =
                   PriceMapper
                           .INSTANCE
                           .mapToPrice(priceDTO);

            price = priceRepo.save(price);

        return ResponseEntity.ok(
                PriceMapper
                        .INSTANCE
                        .mapToPriceDto(price));
    }

    @Override
    public ResponseEntity<?> getByProduct(String token, PriceDTO priceDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllPrices(String token) {
        return null;
    }

    @Override
    public double findPriceByProductForOperationDetails(ProductDTO productDTO) {
        return 0;
    }
}
