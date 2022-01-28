package com.zijie.Message.request;

import com.zijie.Message.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserRequest {
    private String username;
    private String password;
    private String repeatPassword;
    private String nickname;
    private String phoneNumber;
    private Gender gender;
}