package it_schoolkg.sall_services.Models.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuccessLogin {
    String message;
    String token;

    public SuccessLogin(String message, String token) {

    }
}
