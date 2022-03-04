package it_schoolkg.sall_services.Services;

import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.Code;

import java.time.LocalDateTime;

public interface CodeService {

    void saveCode(CodeDTO codeDTO);

    Code findLastCode(UserDTO userDTO);

    void sendCode(UserDTO userDTO, Object sendMessage);

    LocalDateTime getLocalDateTime();
}
