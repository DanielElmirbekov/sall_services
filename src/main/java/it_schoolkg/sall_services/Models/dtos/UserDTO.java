package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Long id;
    String name;
    String login;
    boolean active;
    LocalDateTime block_date;
}
