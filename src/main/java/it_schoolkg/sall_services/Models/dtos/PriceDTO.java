package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceDTO {
    Long id;
    double price;
    LocalDateTime start_date;
    LocalDateTime end_date;

    ProductDTO product;
}
