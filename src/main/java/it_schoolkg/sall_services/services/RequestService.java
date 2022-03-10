package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.CodeDTO;

public interface RequestService {
    void saveRequest(CodeDTO codeDTO, boolean value);

    int countFailedAttempts(CodeDTO codeDTO);
}
