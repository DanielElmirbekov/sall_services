package it_schoolkg.sall_services.Models.dtos;

import it_schoolkg.sall_services.Models.enums.CodeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CodeDTO {
    Long id;
    int code;
    LocalDateTime start_date;
    LocalDateTime end_date;

    @Enumerated
    @Column(name = "Status")
    CodeStatus codeStatus;

    UserDTO user;
}