package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.Code;
import it_schoolkg.sall_services.Models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CodeMapper {
    CodeMapper INSTANCE = Mappers.getMapper(CodeMapper.class);
    CodeDTO mapToCodeDto(Code code);
    Code mapToCode(CodeDTO codeDTO);
}
