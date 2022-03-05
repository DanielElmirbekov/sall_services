package it_schoolkg.sall_services.Services.impl;

import it_schoolkg.sall_services.Mappers.UserMapper;
import it_schoolkg.sall_services.Message.SendSimpleMessage;
import it_schoolkg.sall_services.Message.SimpleMessage;
import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.Code;
import it_schoolkg.sall_services.Models.enums.CodeStatus;
import it_schoolkg.sall_services.Repository.dao.CodeRepo;
import it_schoolkg.sall_services.Services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepo codeRepo;

    @Autowired
    private SendSimpleMessage sendsimpleMessage;

    @Override
    public void saveCode(CodeDTO codeDTO) {
    }

    @Override
    public Code findLastCode(UserDTO userDTO) {
        return codeRepo.findByUserAndCodeStatus(UserMapper.INSTANCE.mapToUser(userDTO), CodeStatus.NEW);
    }

    @Override
    public void sendCode(UserDTO userDTO, Object sendMessage) {

        Code lastCode =
                codeRepo.findByUserAndCodeStatus(UserMapper.INSTANCE.mapToUser(userDTO),CodeStatus.NEW);
        if (Objects.nonNull(lastCode)){
            lastCode.setCodeStatus(CodeStatus.CANCELLED);
            codeRepo.save(lastCode);
        }
        int code = (int) ((Math.random()*9000) + 1000);

        String hashedCode =
                BCrypt
                        .hashpw(
                                Integer
                                        .toString(code)
                                        , BCrypt.gensalt());
        Calendar endOfCodeAction = Calendar.getInstance();
        endOfCodeAction.add(Calendar.MINUTE,3);

        Code saveCode = new Code();
        saveCode.setCode(Integer.parseInt(hashedCode));
        saveCode.setEnd_date(LocalDateTime.MAX); /*********/
        saveCode.setCodeStatus(CodeStatus.NEW);
        saveCode.setUser(UserMapper.INSTANCE.mapToUser(userDTO));
        codeRepo.save(saveCode);

        simpleMessage(userDTO.getLogin(),Integer.toString(code));
    }

    private void simpleMessage(String login, String toString) { /********/

    }
    @Override
    public LocalDateTime getLocalDateTime() {
        return null;
    }

}
