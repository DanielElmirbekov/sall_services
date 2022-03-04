package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestDTO {
    Long id;
    boolean success;
    LocalDateTime add_date;

    CodeDTO code;
}
