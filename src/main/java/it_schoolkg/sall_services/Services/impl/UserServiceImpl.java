package it_schoolkg.sall_services.Services.impl;

import io.jsonwebtoken.*;
import it_schoolkg.sall_services.Exception.OkResponse;
import it_schoolkg.sall_services.Message.SendSimpleMessage;
import it_schoolkg.sall_services.Services.RequestService;
import it_schoolkg.sall_services.Services.UserService;
import it_schoolkg.sall_services.Exception.ErrorResponse;
import it_schoolkg.sall_services.Mappers.CodeMapper;
import it_schoolkg.sall_services.Mappers.UserMapper;
import it_schoolkg.sall_services.Models.responses.SuccessLogin;
import it_schoolkg.sall_services.Models.dtos.CodeDTO;
import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.User;
import it_schoolkg.sall_services.Models.enums.CodeStatus;
import it_schoolkg.sall_services.Repository.dao.UserRepo;
import it_schoolkg.sall_services.Services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CodeService codeService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private SendSimpleMessage sendMessage;

    @Value("qwerty312")
    private String secretKey;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ResponseEntity<?> saveUser(UserDTO userDTO) {
        User user =
                UserMapper
                        .INSTANCE
                        .mapToUser(userDTO);
        if (Objects.isNull(userRepo.findByLogin(user.getLogin()))){
        userRepo
                .save(user);
        }else{
            return new ResponseEntity<>(
                    new ErrorResponse("Пользователь уже существует",null)
                    , HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(
                UserMapper
                        .INSTANCE
                        .mapToUserDto(user));
    }

    @Override
    public boolean userLockOutChecking(User user) {
        if (Objects.nonNull(user.getBlock_date())){
            if(LocalDateTime.now().isBefore(user.getBlock_date())){
                return true;
            }
        }
        return false;
    }


    @Override
    public User findUserByLogin(String login){
        return userRepo.findByLogin(login);}

    @Override
    public ResponseEntity<?> sendCode(String login){
        User user = userRepo.findByLogin(login);

        if (Objects.isNull(user)){
            return new ResponseEntity<>(
                    new ErrorResponse("Некорректный логин!",null)
                    ,HttpStatus.NOT_FOUND);
        }
        boolean check = userLockOutChecking(user);

        if (check){
            SimpleDateFormat formatToShowEndOfBlockDate =
                    new SimpleDateFormat("hh:mm a");
            return new ResponseEntity<>("Превышено количество попыток входа, вы заблокированы.Повторите попытку" +
                    formatToShowEndOfBlockDate
                            .format(
                                    user.getBlock_date())
                                    , HttpStatus.CONFLICT);
        }

        codeService.sendCode(
                UserMapper
                        .INSTANCE
                        .mapToUserDto(user), sendMessage);
        return ResponseEntity.ok(new OkResponse("Код потверждения успешно отправлен!",null));
        //return ResponseEntity.ok(
        //                new OkResponse("Код подтверждения успуешно отправлен!",null));
    }

    @Override
    public ResponseEntity<?> getToken(String login, String code) {
        User user = userRepo.findByLogin(login);

        if (Objects.isNull(user)){
            return new ResponseEntity<>(
                    new ErrorResponse("Некорректный логин!",null)
                    ,HttpStatus.NOT_FOUND);
        }
        boolean check = userLockOutChecking(user);
        if (check) {
            SimpleDateFormat formatToShowEndOfBlockDate =
                    new SimpleDateFormat("hh:mm a");
            return new ResponseEntity<>("Превышено количество попыток входа, вы заблокированы.Повторите попытку через"+
                    formatToShowEndOfBlockDate
                            .format(
                                    user.getBlock_date()),HttpStatus.CONFLICT);//user.getEnd_Date()),HttpStatus.CONFLICT);
        }
        CodeDTO checkUserCode =
                CodeMapper
                        .INSTANCE
                        .mapToCodeDto(
                                codeService
                                        .findLastCode(
                                                UserMapper
                                                        .INSTANCE
                                                        .mapToUserDto(user)));

        if (LocalDateTime.now().isBefore(checkUserCode.getEnd_date())) {

            /*(Objects.nonNull(user.getBlock_date())){
                if(LocalDateTime.now().isBefore(user.getBlock_date())){*/
            //checkUserCode.getEnd_date()
            return new ResponseEntity<>(
                    new ErrorResponse(
                            "Время действия кода потверждения истек!"
                            , "Вам нужно получить код потверждения повторно!")
                    , HttpStatus.CONFLICT);
        }

        if (!BCrypt.checkpw(code , String.valueOf(checkUserCode.getCode()))) { //if (!BCrypt.checkpw(code, checkUserCode.getCode()))
            requestService.saveRequest(checkUserCode, false);
        }


        if (requestService.countFailedAttempts(checkUserCode)=>3){
                //3 <= requestService.countFailedAttempts(checkUserCode.setCode())
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.HOUR,1);

                user.setBlock_date(LocalDateTime.MIN.getMinute());
                userRepo.save(user);

                checkUserCode.setCodeStatus(CodeStatus.FAILED);
                codeService.saveCode(checkUserCode);
            }
            return new ResponseEntity<>(
                    new ErrorResponse("Авторизация не пройдена! \"Вы ввели некоррректный код потверждения\"",null)
                    ,HttpStatus.NOT_FOUND);

        requestService.saveRequest(checkUserCode,true);

        Calendar tokensTimeLive =
                Calendar.getInstance();
        tokensTimeLive
                .add(Calendar.HOUR,3);

        String token =
                Jwts.builder()
                        .claim("login",login)
                        .setExpiration(
                                tokensTimeLive
                                        .getTime())
                        .signWith(
                                SignatureAlgorithm.HS256
                                , secretKey)
                        .compact();

        checkUserCode.setCodeStatus(CodeStatus.APPROVED);
        codeService.saveCode(checkUserCode);

        SuccessLogin successLogin = new SuccessLogin("Вы успешно ввели пароль!",token);
        return ResponseEntity.ok(successLogin);

    }




    @Override
    public ResponseEntity<?> verifyLogin(String token) {
        try {
            Jws<Claims> jwt = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return ResponseEntity.ok(jwt.getBody().get("login"));
        }catch (ExpiredJwtException jwtException){//ExpiredJwtException jwtException

            return new ResponseEntity<>("Время действия токена истек",HttpStatus.CONFLICT);
        }catch (UnsupportedJwtException jwtException){//UnsupportedJwtException jwtException
            return new ResponseEntity<>("Неподерживаемый токен",HttpStatus.CONFLICT);
        }catch (MalformedJwtException jwtException){
            return new ResponseEntity<>("Неккоректный токен",HttpStatus.CONFLICT);
        }catch (SignatureException signatureException){//SignatureException signatureException
            return new ResponseEntity<>("Некорректная подпись в токене!",HttpStatus.CONFLICT);
        }catch (Exception exception){
            return new ResponseEntity<>("unauthorized",HttpStatus.CONFLICT);
        }

    }
}