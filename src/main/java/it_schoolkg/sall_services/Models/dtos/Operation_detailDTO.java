package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Operation_detailDTO {
    Long id;
    int amount;
    int quantity;

    OperationDTO operation;
    ProductDTO product;
}
