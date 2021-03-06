package it_schoolkg.sall_services.Models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int price;
    LocalDateTime start_date;
    LocalDateTime end_date;
    @ManyToOne

    @JoinColumn(name = "id_product")
    Product product;
}