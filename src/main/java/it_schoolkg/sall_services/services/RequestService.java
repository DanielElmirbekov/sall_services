package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.CodeDTO;

public interface RequestService {
    void saveRequest(CodeDTO checkUserCode, boolean value);

    int countFailedAttempts(CodeDTO checkUserCode);
}
