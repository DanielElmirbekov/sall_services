package it_schoolkg.sall_services.Models.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int discount;
    @CreationTimestamp
    LocalDateTime start_date;
    LocalDateTime end_date;
    boolean active;
    @ManyToOne
    @JoinColumn(name = "id_product")
    Product product;

}
