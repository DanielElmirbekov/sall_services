package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Operation_detailDTO {
    Long id;
    double amount;
    int quantity;

    OperationDTO operation;
    ProductDTO product;
}
