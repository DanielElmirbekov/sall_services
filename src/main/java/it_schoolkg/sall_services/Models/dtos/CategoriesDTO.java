package it_schoolkg.sall_services.Models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoriesDTO {
    Long id;
    String name;
    boolean active;
}
