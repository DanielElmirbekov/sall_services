package it_schoolkg.sall_services.Models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Operation_details")
public class Operation_detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int amount;
    double quantity;

    @ManyToOne
    @JoinColumn(name = "id_products")
    Product product;

    @ManyToOne
    @JoinColumn(name = "id_operation")
    Operation operation;
}
