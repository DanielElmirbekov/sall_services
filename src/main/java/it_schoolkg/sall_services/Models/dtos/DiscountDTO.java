package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDTO {
    Long id;
    int discount;
    LocalDateTime start_date;
    LocalDateTime end_date;

    ProductDTO product;
}
