package com.zijie.Message.model;
import com.zijie.Message.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String nickname;
    private String phoneNumber;
    private Date registerTime;
    private Date lastLoginTime;
    private Gender gender;

}

