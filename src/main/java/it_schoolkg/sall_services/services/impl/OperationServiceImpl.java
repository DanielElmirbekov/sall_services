package it_schoolkg.sall_services.services.impl;

import it_schoolkg.sall_services.Models.dtos.InputDataForOperation;
import it_schoolkg.sall_services.services.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    @Override
    public ResponseEntity<?> provideOperation(String token, List<InputDataForOperation> sellinglist) {
        return null;
    }

    @Override
    public ResponseEntity<?> payment(String token, Long operationId, double cash) {
        return null;
    }
}
