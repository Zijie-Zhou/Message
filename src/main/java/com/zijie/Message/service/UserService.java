package com.zijie.Message.service;

import com.zijie.Message.dao.UserDAO;
import com.zijie.Message.enums.Error;
import com.zijie.Message.enums.Gender;
import com.zijie.Message.exception.MessageServiceException;
import com.zijie.Message.model.User;
import com.zijie.Message.request.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void register(RegisterUserRequest request) throws MessageServiceException {
        String username = request.getUsername();
        String password = request.getPassword();
        String repeatPassword = request.getRepeatPassword();
        String nickname = request.getNickname();
        String phoneNumber = request.getPhoneNumber();
        Date registerTime  = new Date();
        Gender gender = request.getGender();
        if(! password.equals(repeatPassword))
        {
            throw new MessageServiceException(Error.PASSWORD_NOT_MATCH);
        }
        User user = new User(username, password, nickname, phoneNumber, registerTime, null, gender);
        userDAO.insert(user);
    }
}
