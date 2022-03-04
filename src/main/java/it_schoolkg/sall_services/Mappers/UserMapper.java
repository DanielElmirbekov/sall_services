package it_schoolkg.sall_services.Mappers;

import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDTO mapToUserDto(User user);

    User mapToUser(UserDTO userDTO);
}


