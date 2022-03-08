package it_schoolkg.sall_services.services;

import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Models.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> saveUser(UserDTO userDTO);

    boolean userLockOutChecking(User user);

    User findUserByLogin(String login);

    ResponseEntity<?> sendCode(String login);

    ResponseEntity<?> getToken(String login, String code);

    ResponseEntity<?> verifyLogin(String token);

    /**ResponseEntity<?>sendCode(String login);
     * ResponseEntity<?>getToken(String login , String code);
     * ResponseEntity<?>verifyLogin(String token);
     * boolean userLockOutChecking(User user);
     * UserfindUserByLogin(String login);
     * */
}