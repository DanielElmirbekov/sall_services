package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.Models.entities.Code;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CodeMapper {

    CodeMapper INSTANCE = Mappers.getMapper(CodeMapper.class);

    @Mapping(source = "user.id",target = "user_id")
    Code mapToCode(CodeDTO codeDTO);

    @Mapping(source = "user.id", target = "user_id")
    CodeDTO mapToCodeDto(Code code);


}
