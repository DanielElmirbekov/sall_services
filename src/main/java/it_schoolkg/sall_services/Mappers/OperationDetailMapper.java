package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.Operation_detailDTO;
import it_schoolkg.sall_services.Models.entities.Operation_detail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationDetailMapper {
    OperationDetailMapper INSTANCE = Mappers.getMapper(OperationDetailMapper.class);

    Operation_detailDTO mapToOperationDetail(Operation_detailDTO operation_detailDTO);

    Operation_detail mapToOperationDetailDTO(Operation_detail operation_detail);
}
