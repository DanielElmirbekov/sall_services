package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperationDTO {
    Long id;
    LocalDateTime add_date;
    float total_price;
    String change;
    int cash;

    UserDTO user;
}
