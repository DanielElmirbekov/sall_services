package it_schoolkg.sall_services.Models.entities;

import it_schoolkg.sall_services.Models.enums.CodeStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Codes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int code;
    LocalDateTime start_date;
    LocalDateTime end_date;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "Status")
    CodeStatus codeStatus;
    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;
}
