package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.OperationDTO;
import it_schoolkg.sall_services.Models.entities.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper {
    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    Operation mapToOperation (OperationDTO operationDTO);

    OperationDTO mapToOperationDTO(Operation operation);
}
