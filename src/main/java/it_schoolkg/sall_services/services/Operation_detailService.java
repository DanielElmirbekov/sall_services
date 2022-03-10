package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.Operation_detailDTO;

import java.util.List;

public interface Operation_detailService {

    void saveOpereationDetails(List<Operation_detailDTO> operation_detailDTOList);
}
