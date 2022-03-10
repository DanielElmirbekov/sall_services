package it_schoolkg.sall_services.Models.entities;

import it_schoolkg.sall_services.Models.enums.CodeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Codes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String code;
    @CreationTimestamp
    LocalDateTime start_date;
    LocalDateTime end_date;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Status")
    CodeStatus codeStatus;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;

}
