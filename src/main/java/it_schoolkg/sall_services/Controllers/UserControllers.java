package it_schoolkg.sall_services.Controllers;

import it_schoolkg.sall_services.Models.dtos.UserDTO;
import it_schoolkg.sall_services.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
public class UserControllers {



     @Autowired
     private UserService userService;

     @PostMapping("/saveUser")
     public ResponseEntity<?>saveUser(@RequestBody UserDTO userDTO){return userService.saveUser(userDTO);}

     @PostMapping("/sendCode")
     public ResponseEntity<?>sendCode(@RequestParam String login){return userService.sendCode(login);}

     @GetMapping("/login")
     public ResponseEntity<?>getToken(@RequestParam String login, @RequestParam String code){return userService.getToken(login,code);}

     @GetMapping("/verify")
     public ResponseEntity<?> verifyLogin(@RequestHeader String token){return userService.verifyLogin(token);}
}
