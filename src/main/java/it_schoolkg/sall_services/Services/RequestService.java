package it_schoolkg.sall_services.Services;

import it_schoolkg.sall_services.Models.dtos.CodeDTO;

public interface RequestService {
    void saveRequest(CodeDTO checkUserCode, boolean value);

    boolean countFailedAttempts(CodeDTO checkUserCode);
}
