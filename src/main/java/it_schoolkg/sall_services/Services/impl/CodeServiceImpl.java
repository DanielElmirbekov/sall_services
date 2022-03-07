package it_schoolkg.sall_services.Services.impl;

import it_schoolkg.sall_services.Mappers.UserMapper;
import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.Code;
import it_schoolkg.sall_services.Models.enums.CodeStatus;
import it_schoolkg.sall_services.Repository.dao.CodeRepo;
import it_schoolkg.sall_services.Services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.security.crypto.bcrypt.BCrypt.gensalt;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepo codeRepo;

    @Autowired
    private CodeServiceImpl sendSimpleMessage;

    @Override
    public void saveCode(CodeDTO codeDTO) {
    }

    @Override
    public Code findLastCode(UserDTO userDTO) {
        return codeRepo.findByUserAndCodeStatus(UserMapper.INSTANCE.mapToUser(userDTO), CodeStatus.NEW);
    }

    @Override
    public ResponseEntity<String> sendCode(UserDTO userDTO) {

        Code lastCode =
                codeRepo.findByUserAndCodeStatus(UserMapper.INSTANCE.mapToUser(userDTO),CodeStatus.NEW);

        if (Objects.nonNull(lastCode)){
            lastCode.setCodeStatus(CodeStatus.CANCELLED);
            codeRepo.save(lastCode);
        }

        int codeRandomizer = (int) (((Math.random() * 9999) + 1000));
        String hashedCode = BCrypt.hashpw(Integer.toString(codeRandomizer),gensalt());
        Code code = new Code();
        code.setStart_date(LocalDateTime.now());
        code.setEnd_date(LocalDateTime.now().plusMinutes(4));
        code.setCodeStatus(CodeStatus.NEW);
        code.setCode(hashedCode);
        code.setId(userDTO.getId());
        code.setUser(UserMapper.INSTANCE.mapToUser(userDTO));
        codeRepo.save(code);
        sendSimpleMessage.sendCode(userDTO.getLogin(),Integer.toString(codeRandomizer));
        return ok("Код отправлен!");

    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return null;
    }

    @Override
    public void sendCode(String login, String toString) {

    }
}