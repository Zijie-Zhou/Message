package com.zijie.Message.service;

import com.zijie.Message.dao.UserDAO;
import com.zijie.Message.enums.Error;
import com.zijie.Message.enums.Gender;
import com.zijie.Message.exception.MessageServiceException;
import com.zijie.Message.model.User;
import com.zijie.Message.request.LoginUserRequest;
import com.zijie.Message.request.RegisterUserRequest;
import com.zijie.Message.encryption.MD5;
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

        String encodePassword = MD5.md5(password);

        User tmpUser1 = userDAO.checkUsername(username);
        User tmpUser2 = userDAO.checkNickname(nickname);
        User tmpUser3 = userDAO.checkPhone_number(phoneNumber);

        if(tmpUser1 != null)
        {
            throw new MessageServiceException(Error.USER_ALREADY_EXISTS);
        }

        if(tmpUser2 != null)
        {
            throw new MessageServiceException(Error.NICKNAME_ALREADY_EXISTS);
        }

        if(tmpUser3 != null)
        {
            throw new MessageServiceException(Error.PHONE_ALREADY_EXISTS);
        }

        User user = new User(username, encodePassword, nickname, phoneNumber, registerTime, null, gender);

        userDAO.insert(user);
    }

    public void login(LoginUserRequest request) throws MessageServiceException {

        String username = request.getUsername();
        String password = request.getPassword();

        String encodePassword = MD5.md5(password);

        User userEntity  = userDAO.checkUsername(username);

        if(userEntity == null)
        {
            throw new MessageServiceException(Error.USER_NOT_EXISTS);
        }

        String originalPassword = userDAO.checkPassword(username);

        if(! originalPassword.equals(encodePassword))
        {
            throw new MessageServiceException(Error.PASSWORD_NOT_RIGHT);
        }

    }

}
