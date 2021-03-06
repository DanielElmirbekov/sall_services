package it_schoolkg.sall_services.services.impl;

import it_schoolkg.sall_services.Mappers.CodeMapper;
import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.repository.dao.RequestRepo;
import it_schoolkg.sall_services.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepo requestRepo;

    @Override
    public void saveRequest(CodeDTO checkUserCode, boolean value) {

    }

    @Override
    public int countFailedAttempts(CodeDTO codeDTO) {
        return requestRepo
                .countByCodeAndSuccess(
                        CodeMapper
                                .INSTANCE
                                .mapToCode(codeDTO)
                        ,false);
    }
}
