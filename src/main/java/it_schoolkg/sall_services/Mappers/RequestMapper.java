package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.RequestDTO;
import it_schoolkg.sall_services.Models.entities.Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestMapper {
    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    @Mapping(source = "code.id", target = "code_id")
    Request mapToRequest (RequestDTO requestDTO);

    @Mapping(source = "code.id", target = "code_id")
    RequestDTO mapToRequestDTO (Request request);
}
