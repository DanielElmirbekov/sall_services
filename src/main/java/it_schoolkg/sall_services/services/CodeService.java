package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.Code;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface CodeService {

    void saveCode(CodeDTO codeDTO);

    Code findLastCode(UserDTO userDTO);

    ResponseEntity<String> sendCode(UserDTO userDTO);

    LocalDateTime getLocalDateTime();

    void sendCode(String login, String toString);
}
