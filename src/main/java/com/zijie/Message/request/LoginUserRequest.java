package com.zijie.Message.request;

import com.zijie.Message.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginUserRequest {

    private String username;
    private String password;
}
